#!/usr/bin/env ruby
require 'win32ole'

$urls = []

#����ȫ�ֱ���$ie��Ϊie�Զ����ͻ��˵�����
$ie = nil
def navigate(url)
  $urls << url

  if url['sina'] || url['yahoo']
  #������sina����yahoo������ת��google
      $ie.navigate('http://www.google.com')
  end
end

#ֹͣ��Ϣѭ��
def stop_msg_loop
  puts "Now Stop IE..."
  $LOOP = FALSE;
end

#Ĭ�ϵĴ�����
def default_handler(event, *args)
  case event
  when "BeforeNavigate"
    puts "Now Navigate #{args[0]}..."
  end
end

#����IE�Զ����ͻ���
$ie = WIN32OLE.new('InternetExplorer.Application')
$ie.visible = TRUE
$ie.gohome

###############################################
#ͨ��WIN32OLE_EVENTע�����DWebBrowserEvents
#���DispatchEvent�ӿڵ����ӵ�
###############################################
ev = WIN32OLE_EVENT.new($ie, 'DWebBrowserEvents')


###############################################
#������Ը��ֽӿ��¼��Ļص�����
# default_handler(*args):Ĭ�ϵ��¼�����
# navigate(url): NavigateComplete�¼��Ĵ���
# stop_msg_loop:Quit�¼��Ĵ���
###############################################

ev.on_event {|*args| default_handler(*args)}
ev.on_event("NavigateComplete") {|url| navigate(url)}
ev.on_event("Quit") {|*args| stop_msg_loop}

$LOOP = TRUE
while ($LOOP)
  WIN32OLE_EVENT.message_loop
end

#��ӡ��Щ��������ʹ���URL
puts "You Navigated the URLs ..."
$urls.each_with_index do |url, i|
  puts "(#{i+1}) #{url}"
end
