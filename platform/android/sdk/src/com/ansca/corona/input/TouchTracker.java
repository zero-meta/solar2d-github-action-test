//////////////////////////////////////////////////////////////////////////////
//
// This file is part of the Corona game engine.
// For overview and more information on licensing please refer to README.md 
// Home page: https://github.com/coronalabs/corona
// Contact: support@coronalabs.com
//
//////////////////////////////////////////////////////////////////////////////

package com.ansca.corona.input;


/** Tracks the touch events from one inpute device for a single finger/pointer. */
public class TouchTracker implements Cloneable {
	/** Provides unique IDs for every touch tracker. */
	private static int sNextTouchId = 0;

	/** Unique integer ID of the touch point. This is the ID assigned to the Lua touch event. */
	private int fTouchId;

	/** The unique integer ID of the device the touch event came from. */
	private int fDeviceId;

	/**
	 * The unique integer ID of the touch pointer the touch event came from.
	 * This typically represents a single finger that is currently pressed on the screen.
	 */
	private int fPointerId;

	/** The coordinate where the touch event began. */
	private TouchPoint fStartPoint;

	/** The current/last touch event coordinate. */
	private TouchPoint fLastPoint;

	/** The current touch phase such as BEGAN, MOVED, or ENDED. */
	private TouchPhase fPhase;

	/** The current pressure used. */
	private boolean fSupportsPressure;
	private float fPressure;


	/**
	 * Creates a new tracker for recording touch events from a single finger/pointer on a device.
	 * @param deviceId Unique integer ID of the device the touch events are coming from.
	 *                 This typically comes from the MotionEvent.getDeviceId() method.
	 * @param pointerId Unique integer ID of the single finger/pointer that is generating touch events.
	 *                  This typically comes from the MotionEvent.getPointerId() method.
	 */
	public TouchTracker(int deviceId, int pointerId) {
		sNextTouchId++;
		fTouchId = sNextTouchId;
		fDeviceId = deviceId;
		fPointerId = pointerId;
		fSupportsPressure = false;
		reset();
	}

	/**
	 * Creates a new copy of this object.
	 * @return Returns a copy of this object.
	 */
	@Override
	public TouchTracker clone() {
		TouchTracker clone = null;
		try {
			clone = (TouchTracker)super.clone();
		}
		catch (Exception ex) { }
		return clone;
	}

	/**
	 * Resets touch tracking by clearing the start and end points.
	 * <p>
	 * After resetting this object, you cannot call this object's get methods until you have set the
	 * start point or else an exception will occur.
	 */
	public void reset() {
		fStartPoint = null;
		fLastPoint = null;
		fPhase = null;
		fPressure = -1.0f;
		fSupportsPressure = false;
	}

	/**
	 * Determines if touch tracking has started.
	 * <p>
	 * This method will not return true until you provide this tracker its first touch point
	 * via the updateWith() method.
	 * @return Returns true if touch tracking has started. Returns false if not.
	 */
	public boolean hasStarted() {
		return (fStartPoint != null);
	}

	/**
	 * Determines if touch tracking has not been started yet.
	 * <p>
	 * This method will return true if this tracker has not been given any touch point data.
	 * You cannot call this tracker's get methods until tracking has been started.
	 * @return Returns true if touch tracking has not been started yet. Returns false if it is tracking.
	 */
	public boolean hasNotStarted() {
		return !hasStarted();
	}

	/**
	 * Gets the unique integer ID assigned to single the finger/pointer that is causing the touch events.
	 * <p>
	 * This ID is generated by Corona, not Android.
	 * @return Returns a unique integer ID used by Corona's touch event in Lua.
	 */
	public int getTouchId() {
		return fTouchId;
	}

	/**
	 * Gets the unique integer ID assigned to the device that the touch events are coming from.
	 * <p>
	 * This ID comes form the Android MotionEvent that raised the touch event.
	 * @return Returns the device's unique integer ID.
	 */
	public int getDeviceId() {
		return fDeviceId;
	}

	/**
	 * Gets the unique integer ID assigned to the single finger/pointer that the touch events are coming from.
	 * <p>
	 * This ID comes from the Android MotionEvent that raised the touch event.
	 * @return Returns the ID for the finger/pointer that the touch events are coming from.
	 */
	public int getPointerId() {
		return fPointerId;
	}

	/**
	 * Gets the point where touch tracking began.
	 * <p>
	 * You should not call this method until the hasStarted() method has returned true.
	 * @return Returns the point where touch events started.
	 *         <p>
	 *         Returns null if touch tracking has not started yet.
	 */
	public TouchPoint getStartPoint() {
		return fStartPoint;
	}

	/**
	 * Gets the current/last touch point received.
	 * <p>
	 * You should not call this method until the hasStarted() method has returned true.
	 * @return Returns the current/last touch point received.
	 *         <p>
	 *         Returns null if touch tracking has not been started yet.
	 */
	public TouchPoint getLastPoint() {
		return fLastPoint;
	}

	/**
	 * Gets the current touch phase such as BEGAN, MOVED, or ENDED.
	 * <p>
	 * You should not call this method until the hasStarted() method has returned true.
	 * @return Returns the current touch phase.
	 *         <p>
	 *         Returns null if touch tracking has not been started yet.
	 */
	public TouchPhase getPhase() {
		return fPhase;
	}

	/**
	 * Gets the current touch pressure. This is normalized value such that 1.0 is the
	 * standard user's normal "touch" pressure. Some devices provide higher values.
	 * <p>
	 * You should not call this method until the hasStarted() method has returned true.
	 * @return Returns the current touch pressure.
	 *         <p>
	 *         Returns -1.0 (invalid pressure) if touch tracking has not been started yet,
	 *         or if the device does not support pressure.
	 */
	public float getPressure() {
		return fSupportsPressure ? fPressure : -1.0f;
	}

	/**
	 * Updates this tracker with the given point.
	 * <p>
	 * The getStartPoint() method will return the given touch point if this is the first time
	 * this method has been called, after calling this tracker's reset() method, or if you set
	 * the given phase to BEGAN.
	 * <p>
	 * The hasStarted() method will return true after calling this method.
	 * @param point The touch point that was received. Cannot be null.
	 * @param phase The current touch phase such as BEGAN, MOVED, or ENDED. Cannot be null.
	 */
	public void updateWith(TouchPoint point, TouchPhase phase) {
		updateWith(point, phase, -1.0f);
	}

	public void updateWith(TouchPoint point, TouchPhase phase, float pressure) {
		// Validate arguments.
		if ((point == null) || (phase == null)) {
			throw new NullPointerException();
		}

		// Set the start point, if applicable.
		if ((fStartPoint == null) || (phase == TouchPhase.BEGAN)) {
			fStartPoint = point;
		}

		// Store the current touch point and phase.
		fLastPoint = point;
		fPhase = phase;

		// TODO: This disables pressure functionality until we can find a reliable means of 
		// obtaining pressure values.
		pressure = -1.0f;

		// Store the current pressure applied to the touch.
		// Negative values mean that pressure is not supported by the providing device, and are
		// not fed to the user.
		// Because some devices return an arbitrary, constant value for pressure, we must first
		// check to see if the pressure value has changed before we enable sending back pressure
		// data.
		if ( !fSupportsPressure && fPressure >= 0.0f && fPressure != pressure ) {
			fSupportsPressure = true;
		}
		fPressure = pressure;
	}
}