#!c:/ruby/bin/ruby.exe
require 'Win32API'

#ȡ��API ����GetCursorPos
getCursorPos = Win32API.new("user32", "GetCursorPos", ['P'], 'V')

#ʹ��string������ռ䣬�洢����LONG
lpPoint = " " * 8 # store two LONGs
getCursorPos.Call(lpPoint)

#unpack����������������;
x, y = lpPoint.unpack("LL") # get the actual values

print "x: ", x, "\n"
print "y: ", y, "\n"

ods = Win32API.new("kernel32", "OutputDebugString", ['P'], 'V')
ods.Call("Hello, World\n")

GetDesktopWindow = Win32API.new("user32", "GetDesktopWindow", [], 'L')
GetActiveWindow = Win32API.new("user32", "GetActiveWindow", [], 'L')

SendMessage = Win32API.new("user32", "SendMessage", ['L'] * 4, 'L')
SendMessage.Call GetDesktopWindow.Call, 274, 0xf140, 0
