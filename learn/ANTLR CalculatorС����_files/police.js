/*�����û�������������ʼʱ��*/
if(Cookie.get("enterClubTime") == null){
	Cookie.set("enterClubTime", new Date().getTime());
}

/*isRecursive��ʾ�Ƿ�ѭ����*/
function showPoliceFlash(url, isRecursive, interval){
	if(document.getElementById("policeDiv") == null)
		return;
	document.getElementById("policeDiv").style.top = (document.body.scrollTop?document.body.scrollTop:document.documentElement.scrollTop) + ((document.body.clientHeight > document.documentElement.clientHeight)?document.documentElement.clientHeight:document.body.clientHeight) -110+ 'px';
	document.getElementById("policeDiv").innerHTML = 
			"<EMBED src="+url+" quality=high width=700 height=100 wmode='transparent' TYPE='application/x-shockwave-flash' PLUGINSPAGE='http://www.macromedia.com/shockwave/download/index.cgi?P1_Prod_Version=ShockwaveFlash'></EMBED>";
	if(isRecursive && interval != null){//ѭ��
		window.setTimeout("showPoliceFlash('"+url+"', true, "+interval+")",  interval);
	}
}

function policyInit(){
	var policyDivElement = document.createElement("div");
	policyDivElement.id="policeDiv";
	document.body.appendChild(policyDivElement);
	if(document.getElementById("policeDiv") != null){
		document.getElementById("policeDiv").style.textAlign = "center";
		document.getElementById("policeDiv").style.position = "absolute";
		document.getElementById("policeDiv").style.width = "800px";
		document.getElementById("policeDiv").style.left = "0px";
		var buxunTime = 3 * 60 * 1000;//3����
		var recursiveTime = 45 * 60 * 1000;//45����
		var curTime = new Date().getTime();
		var entClubTime = Cookie.get("enterClubTime");
		if(curTime - entClubTime < buxunTime)//3���ӳ��ֲ���Ѳ��
			window.setTimeout("showPoliceFlash('http://pimg.163.com/club/club2007/police/police-buxun.swf', false)",  buxunTime - (curTime - entClubTime));
		if(((curTime - entClubTime) / recursiveTime) % 2 == 0){//ѭ�����ֳ��־���Ѳ����Ħ�г�Ѳ��
			window.setTimeout("showPoliceFlash('http://pimg.163.com/club/club2007/police/police-jingche.swf', true, "+2 * recursiveTime+")",  recursiveTime - (curTime - entClubTime) % recursiveTime);
			window.setTimeout("showPoliceFlash('http://pimg.163.com/club/club2007/police/police-motuo.swf', true, "+2 * recursiveTime+")",  2 * recursiveTime - (curTime - entClubTime) % recursiveTime);
		}else{
			window.setTimeout("showPoliceFlash('http://pimg.163.com/club/club2007/police/police-motuo.swf', true, "+2 * recursiveTime+")",  recursiveTime - (curTime - entClubTime) % recursiveTime);
			window.setTimeout("showPoliceFlash('http://pimg.163.com/club/club2007/police/police-jingche.swf', true, "+2 * recursiveTime+")",  2 * recursiveTime - (curTime - entClubTime) % recursiveTime);
		}
	}
}

window.setTimeout(policyInit, 5000);