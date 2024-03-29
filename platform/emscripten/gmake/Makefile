# GNU Make solution makefile autogenerated by Premake
# Type "make help" for usage help

ifndef config
  config=Debug
endif
export config

PROJECTS := lua2cpp z png jpeg Box2D Renderer rtt lfs lpeg lua ratatouille corona

.PHONY: all clean help $(PROJECTS)

all: $(PROJECTS)

Box2D: 
	@echo "==== Building Box2D ($(config)) ===="
	@${MAKE} --no-print-directory -C . -f Box2D.make

Renderer: 
	@echo "==== Building Renderer ($(config)) ===="
	@${MAKE} --no-print-directory -C . -f Renderer.make

lua2cpp: 
	@echo "==== Compiling Lua to cpp ===="
	@${MAKE} --no-print-directory -C . -f lua2cpp.make

rtt: lua2cpp
	@echo "==== Building rtt ($(config)) ===="
	@${MAKE} --no-print-directory -C . -f rtt.make

lfs: 
	@echo "==== Building lfs ($(config)) ===="
	@${MAKE} --no-print-directory -C . -f lfs.make

lpeg: 
	@echo "==== Building lpeg ($(config)) ===="
	@${MAKE} --no-print-directory -C . -f lpeg.make

z: 
	@echo "==== Building libz ($(config)) ===="
	@${MAKE} --no-print-directory -C . -f z.make

png: 
	@echo "==== Building libpng ($(config)) ===="
	@${MAKE} --no-print-directory -C . -f png.make

jpeg: 
	@echo "==== Building libjpeg ($(config)) ===="
	@${MAKE} --no-print-directory -C . -f jpeg.make

lua: 
	@echo "==== Building lua ($(config)) ===="
	@${MAKE} --no-print-directory -C . -f lua.make

ratatouille: lua2cpp
	@echo "==== Building ratatouille ($(config)) ===="
	@${MAKE} --no-print-directory -C . -f ratatouille.make

corona: lua2cpp Box2D Renderer lfs lpeg lua ratatouille rtt z png jpeg
	@echo "==== Building corona ($(config)) ===="
	@${MAKE} --no-print-directory -C . -f corona.make

clean:
	@${MAKE} --no-print-directory -C . -f Box2D.make clean
	@${MAKE} --no-print-directory -C . -f Renderer.make clean
	@${MAKE} --no-print-directory -C . -f rtt.make clean
	@${MAKE} --no-print-directory -C . -f lfs.make clean
	@${MAKE} --no-print-directory -C . -f lpeg.make clean
	@${MAKE} --no-print-directory -C . -f z.make clean
	@${MAKE} --no-print-directory -C . -f lua.make clean
	@${MAKE} --no-print-directory -C . -f png.make clean
	@${MAKE} --no-print-directory -C . -f jpeg.make clean
	@${MAKE} --no-print-directory -C . -f ratatouille.make clean
	@${MAKE} --no-print-directory -C . -f corona.make clean
	@${MAKE} --no-print-directory -C . -f lua2cpp.make clean

help:
	@echo "Usage: make [config=name] [target]"
	@echo ""
	@echo "CONFIGURATIONS:"
	@echo "   Debug"
	@echo "   Release"
	@echo ""
	@echo "TARGETS:"
	@echo "   all (default)"
	@echo "   clean"
	@echo "   Box2D"
	@echo "   Renderer"
	@echo "   rtt"
	@echo "   lfs"
	@echo "   lpeg"
	@echo "   z"
	@echo "   lua"
	@echo "   png"
	@echo "   jpeg"
	@echo "   ratatouille"
	@echo "   corona"
	@echo "   lua2cpp"
	@echo ""
	@echo "For more information, see http://industriousone.com/premake/quick-start"
