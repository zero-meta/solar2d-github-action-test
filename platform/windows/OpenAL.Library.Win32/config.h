/*
// ----------------------------------------------------------------------------
// 
// config.h
// Copyright (c) 2015 Corona Labs Inc. All rights reserved.
//
// This file was generated by Corona Labs and is used by the open source
// OpenAL library to define what its capabilites are on a Win32 platform.
// All OpenAL *.c files include this header file.
//
// Reviewers:
// 		Joshua Quick
//
// ----------------------------------------------------------------------------
*/

#pragma once

#include <stdio.h>
#include <string.h>

/* Disable all of the compiler warnings that this open source library is guilty of. */
#pragma warning(disable:4244)
#pragma warning(disable:4305)
#pragma warning(disable:4996)


/* Define to the library version */
#define ALSOFT_VERSION "1.12.854"

/* Define if we have the DSound backend */
#define HAVE_DSOUND

/* Define if we have the stat function */
#define HAVE_STAT

/* Define if we have the powf function */
#define HAVE_POWF

/* Define if we have the sqrtf function */
#define HAVE_SQRTF

/* Define if we have the acosf function */
#define HAVE_ACOSF

/* Define if we have the atanf function */
#define HAVE_ATANF

/* Define if we have the fabsf function */
#define HAVE_FABSF

/* Define if we have the strtof function */
#define HAVE_STRTOF

/* Define if we have stdint.h */
#define HAVE_STDINT_H

/* Define if we have the __int64 type */
#define HAVE___INT64

/* Define to the size of a long int type */
#define SIZEOF_LONG 4

/* Define to the size of a long long int type */
#define SIZEOF_LONG_LONG 8

/* Define to the size of an unsigned int type */
#define SIZEOF_UINT 4

/* Define to the size of a void pointer type */
#ifdef _M_X64
#	define SIZEOF_VOIDP 8
#else
#	define SIZEOF_VOIDP 4
#endif

/* Define if we have float.h */
#define HAVE_FLOAT_H

/* Define if we have _controlfp() */
#define HAVE__CONTROLFP

/* Macro replace POSIX strcasecmp() with the Win32 _stricmp() equivalent function. */
#define strcasecmp _stricmp

/* Macro replace POSIX strncasecmp() with the Win32 _strnicmp() equivalent function. */
#define strncasecmp _strnicmp

/* Macro replace C99 snprintf() with the Win32 _snprintf() equivalent function. */
#define snprintf _snprintf

