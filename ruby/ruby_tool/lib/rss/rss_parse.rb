require 'rss/1.0'         
require 'rss/2.0'         
require 'open-uri'         
        
# feed= "http://news.csdn.net/Feed.aspx?Column=15666b36-9a91-403c-ab31-2ebce8d6b4e8" # url�򱾵�XML�ļ�  
# feed = "http://rss.51job.com/rss/0200/Rss_0200_0600.xml"	# hr
feed = "http://rss.51job.com/rss/0200/Rss_0200_0100.xml"    # cs
content = ""         
open(feed) do |s|       
	content = s.read       
end       
rss = RSS::Parser.parse(content, false) # false��ʾ����֤feed�ĺϷ���  

channel = rss.channel   
items = rss.items # rss.channel.items���   
  
puts "Ƶ����Ϣ"  
puts "���⣺ #{channel.title}"  
puts "���ӣ� #{channel.link}"  
puts "������ #{channel.description}"  
puts "����ʱ�䣺 #{channel.date}"  
puts "���������� #{items.size}"  

content = ""
  
for i in 0 ... items.size   
	content += "#{items[i].link}\r\n"
=begin	
  puts "----------- ����#{i} -----------"  
  puts "\t���⣺ #{items[i].title}"  
  puts "\t���ӣ� #{items[i].link}"  
  puts "\t����ʱ�䣺 #{items[i].date}"  
  puts "\t���ݣ� #{items[i].description}"  
=end  
end  

file_name = "rss_#{Time.new.to_i}.txt"
File.open(file_name, "w+") do |file|
	file.write(content)
end

