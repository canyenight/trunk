<!--[442,2,1] published at 2008-05-06 11:04:27 from #237 by 1786-->
if(typeof Util=='undefined')Util={};Util.bg=function(){this.Init.apply(this,arguments);};Util.bg.prototype={dy:0,cG:"",cS:8,Init:function(){},dv:function(s){return this.cL(this.cV(this.fh(s),s.length*this.cS));},cV:function(x,dI){x[dI>>5]|=0x80<<(24-dI%32);x[((dI+64>>9)<<4)+15]=dI;var w=Array(80);var a=1732584193;var b=-271733879;var c=-1732584194;var d=271733878;var e=-1009589776;for(var i=0;i<x.length;i+=16){var ev=a;var ew=b;var ez=c;var eA=d;var eB=e;for(var j=0;j<80;j++){if(j<16)w[j]=x[i+j];else w[j]=this.eS(w[j-3]^w[j-8]^w[j-14]^w[j-16],1);var t=this.eU(this.eU(this.eS(a,5),this.fc(j,b,c,d)),this.eU(this.eU(e,w[j]),this.fd(j)));e=d;d=c;c=this.eS(b,30);b=a;a=t;}a=this.eU(a,ev);b=this.eU(b,ew);c=this.eU(c,ez);d=this.eU(d,eA);e=this.eU(e,eB);}return Array(a,b,c,d,e);},fc:function(t,b,c,d){if(t<20)return(b&c)|((~b)&d);if(t<40)return b^c^d;if(t<60)return(b&c)|(b&d)|(c&d);return b^c^d;},fd:function(t){return(t<20)?1518500249:(t<40)?1859775393:(t<60)?-1894007588:-899497514;},eU:function(x,y){var dK=(x&0xFFFF)+(y&0xFFFF);var dW=(x>>16)+(y>>16)+(dK>>16);return(dW<<16)|(dK&0xFFFF);},eS:function(dZ,cT){return(dZ<<cT)|(dZ>>>(32-cT));},fh:function(fg){var aX=Array();var dL=(1<<this.cS)-1;for(var i=0;i<fg.length*this.cS;i+=this.cS)aX[i>>5]|=(fg.charCodeAt(i/this.cS)&dL)<<(32-this.cS-i%32);return aX;},cL:function(cK){var dx=this.dy?"0123456789ABCDEF":"0123456789abcdef";var fg="";for(var i=0;i<cK.length*4;i++){fg+=dx.charAt((cK[i>>2]>>((3-i%4)*8+4))&0xF)+dx.charAt((cK[i>>2]>>((3-i%4)*8))&0xF);}return fg;}};if(typeof Util=='undefined')Util={};if(typeof $=='undefined')$=function(id){return document.getElementById(id)};if(typeof $C=='undefined')$C=function(t){return document.createElement(t)};if(typeof $S=='undefined')$S={};Util.dF=function(){this.Init.apply(this,arguments);};Util.dF.prototype={eo:null,en:null,Init:function(aO,aN){if(typeof aN=='string')this.en=$(aN);else this.en=aN;if(typeof aO=='string')this.en=$(aO);else this.eo=aO;},bi:function(aC,aA,Z){this.dT=aC;this.dQ=aA;this.bO=Z;this.cB();},cB:function(){var cy=this;var dT=this.dT;var dQ=this.dQ;this.eo.onmousedown=function(dh){cy.en.style.width=cy.en.clientWidth+"px";cy.en.style.height=cy.en.clientHeight+"px";document.onmousemove=function(dh){var e=(window.event)?window.event:dh;if(cy.eI)cy.eI(e);var ey=e.clientY;var ex=e.clientX;var cQ=0;var cP=0;var fr=0;var ft=0;if(cy.dG&&cy.dH){fr=ex-cy.dG;ft=ey-cy.dH;if(fr){cQ=(parseInt(cy.en.style.width)+fr);if(cQ>=dT){if(cy.eJ)cy.eJ(fr,cQ);cy.en.style.width=cQ+'px';}}if(ft){cP=(parseInt(cy.en.style.height)+ft);if(cP>=dQ){if(cy.eG)cy.eG(ft,cP);cy.en.style.height=cP+'px';}}if(cy.bO)document.title='mouse x: '+ex+' mouse y: '+ey+' x eu:'+(ex-cy.dG)+'y eu:'+(ey-cy.dH)+'box h:'+cy.en.style.height+' box W:'+cy.en.style.width;}cy.dG=ex;cy.dH=ey;};document.onmouseup=function(dh){var e=(window.event)?window.event:dh;document.onmousemove=null;document.onmouseup=null;if(cy.eH)cy.eH(e,cy.dG,cy.dH);cy.dG=null;cy.dH=null;};};}};if(typeof Util=='undefined')Util={};Util.ac={et:null,dB:function(o,ep,dU,dO,dV,dP,cH,cI,dj,dk){o.onmousedown=Util.ac.start;o.dz=cH?false:true;o.fp=cI?false:true;o.root=ep&&ep!=null?ep:o;if(o.dz&&isNaN(parseInt(o.root.style.left)))o.root.style.left="0px";if(o.fp&&isNaN(parseInt(o.root.style.top)))o.root.style.top="0px";if(!o.dz&&isNaN(parseInt(o.root.style.right)))o.root.style.right="0px";if(!o.fp&&isNaN(parseInt(o.root.style.bottom)))o.root.style.bottom="0px";o.dU=typeof dU!='undefined'?dU:null;o.dV=typeof dV!='undefined'?dV:null;o.dO=typeof dO!='undefined'?dO:null;o.dP=typeof dP!='undefined'?dP:null;o.fq=dj?dj:null;o.fs=dk?dk:null;o.root.eE=new Function();o.root.eD=new Function();o.root.eC=new Function();},start:function(e){var o=Util.ac.et=this;e=Util.ac.dn(e);var y=parseInt(o.fp?o.root.style.top:o.root.style.bottom);var x=parseInt(o.dz?o.root.style.left:o.root.style.right);o.root.eE(x,y);o.dG=e.clientX;o.dH=e.clientY;if(o.dz){if(o.dU!=null)o.dR=e.clientX-x+o.dU;if(o.dO!=null)o.dM=o.dR+o.dO-o.dU;}else{if(o.dU!=null)o.dM=-o.dU+e.clientX+x;if(o.dO!=null)o.dR=-o.dO+e.clientX+x;}if(o.fp){if(o.dV!=null)o.dS=e.clientY-y+o.dV;if(o.dP!=null)o.dN=o.dS+o.dP-o.dV;}else{if(o.dV!=null)o.dN=-o.dV+e.clientY+y;if(o.dP!=null)o.dS=-o.dP+e.clientY+y;}document.onmousemove=Util.ac.de;document.onmouseup=Util.ac.dg;return false;},de:function(e){e=Util.ac.dn(e);var o=Util.ac.et;var ey=e.clientY;var ex=e.clientX;var y=parseInt(o.fp?o.root.style.top:o.root.style.bottom);var x=parseInt(o.dz?o.root.style.left:o.root.style.right);var ea,eb;if(o.dU!=null)ex=o.dz?Math.max(ex,o.dR):Math.min(ex,o.dM);if(o.dO!=null)ex=o.dz?Math.min(ex,o.dM):Math.max(ex,o.dR);if(o.dV!=null)ey=o.fp?Math.max(ey,o.dS):Math.min(ey,o.dN);if(o.dP!=null)ey=o.fp?Math.min(ey,o.dN):Math.max(ey,o.dS);ea=x+((ex-o.dG)*(o.dz?1:-1));eb=y+((ey-o.dH)*(o.fp?1:-1));if(o.fq)ea=o.fq(y);else if(o.fs)eb=o.fs(x);Util.ac.et.root.style[o.dz?"left":"right"]=ea+"px";Util.ac.et.root.style[o.fp?"top":"bottom"]=eb+"px";Util.ac.et.dG=ex;Util.ac.et.dH=ey;Util.ac.et.root.eC(ea,eb);return false;},dg:function(){document.onmousemove=null;document.onmouseup=null;Util.ac.et.root.eD(parseInt(Util.ac.et.root.style[Util.ac.et.dz?"left":"right"]),parseInt(Util.ac.et.root.style[Util.ac.et.fp?"top":"bottom"]));Util.ac.et=null;},dn:function(e){if(typeof e=='undefined')e=window.event;if(typeof e.layerX=='undefined')e.layerX=e.offsetX;if(typeof e.layerY=='undefined')e.layerY=e.offsetY;return e;}};if(typeof Util=='undefined')Util={};Util.P=function(){this.Init.apply(this,arguments);};Util.P.prototype={Init:function(){},dJ:function(v,w){var fo=v.length;var ff=v[fo-1]&0xffffffff;for(var i=0;i<fo;i++){v[i]=String.fromCharCode(v[i]&0xff,v[i]>>>8&0xff,v[i]>>>16&0xff,v[i]>>>24&0xff);}if(w){return v.join('').substring(0,ff);}else{return v.join('');}},fi:function(s,w){var dI=s.length;var v=[];for(var i=0;i<dI;i+=4){v[i>>2]=s.charCodeAt(i)|s.charCodeAt(i+1)<<8|s.charCodeAt(i+2)<<16|s.charCodeAt(i+3)<<24;}if(w){v[v.length]=dI;}return v;},cY:function(fg,dE,dD){if(fg==""){return "";}if(dD)fg=this.dw(fg);var v=this.fi(fg,false);var k=this.fi(dE,false);var n=v.length-1;var z=v[n-1],y=v[0],cZ=0x9E3779B9;var dX,e,q=Math.floor(6+52/(n+1)),fk=q*cZ&0xffffffff;while(fk!=0){e=fk>>>2&3;for(var p=n;p>0;p--){z=v[p-1];dX=(z>>>5^y<<2)+(y>>>3^z<<4)^(fk^y)+(k[p&3^e]^z);y=v[p]=v[p]-dX&0xffffffff;}z=v[n];dX=(z>>>5^y<<2)+(y>>>3^z<<4)^(fk^y)+(k[p&3^e]^z);y=v[0]=v[0]-dX&0xffffffff;fk=fk-cZ&0xffffffff;}return this.dJ(v,true);},dw:function(h){var r="";for(var i=(h.substr(0,2)=="0x")?2:0;i<h.length;i+=2)r+=String.fromCharCode(parseInt(h.substr(i,2),16));return r;}};if(typeof S_WC=='undefined')S_WC={};if(typeof $=='undefined')$=function(id){return document.getElementById(id)};if(typeof $C=='undefined')$C=function(t){return document.createElement(t)};if(typeof $S=='undefined')$S={};S_WC.MyConf={ae:true,bG:false,A:{bt:'pub_cli',bu:'http://i0.sinaimg.cn/woocall/cli/',bq:'.js',bs:'woocall_swf_file',bI:380,ar:326,az:200,aB:350,ay:10,an:true,aL:'RightBottom',au:false},al:{width:150,av:34},bw:'http://i0.sinaimg.cn/ent/woocall/Theme/',O:'http://pub.woocall.sina.com.cn/cgi-bin/s_wc_core2?v=5',U:'_CtrlBtn',B:'_ChatBox',aE:'S_WC',ap:'_FLA_BOX',ai:'_EXT_BOX',aI:10,aZ:'r',bf:191,aV:62,be:'与同时访问此页面的网友聊天',aW:true,bo:false,aK:'9icn4po62xa2nbcd',bC:0};function LdPgCfg(J){if(typeof SINA_WOOCALL_CONFIG!='undefined'){if(SINA_WOOCALL_CONFIG.URLCutCharLen){J.bC=SINA_WOOCALL_CONFIG.URLCutCharLen;}if(SINA_WOOCALL_CONFIG.Popup){J.A.au=true;J.aW=false;}if(SINA_WOOCALL_CONFIG.DispPosi){J.A.aL=SINA_WOOCALL_CONFIG.DispPosi;}if(SINA_WOOCALL_CONFIG.CustomURL){J.V=SINA_WOOCALL_CONFIG.CustomURL;}if(SINA_WOOCALL_CONFIG.TopicHeader){J.ak=SINA_WOOCALL_CONFIG.TopicHeader;}if(SINA_WOOCALL_CONFIG.Stealth){J.bo=true;J.A.au=true;J.aW=true;}if(SINA_WOOCALL_CONFIG.Disable){J.ae=false;}if(SINA_WOOCALL_CONFIG.ExtraPanelDisable){J.ag=false;}if(SINA_WOOCALL_CONFIG.ExtraPanelURL){J.al.aG=SINA_WOOCALL_CONFIG.ExtraPanelURL;}if(SINA_WOOCALL_CONFIG.SBarPosi){J.aZ=SINA_WOOCALL_CONFIG.SBarPosi;}if(SINA_WOOCALL_CONFIG.StandPoint&&SINA_WOOCALL_CONFIG.StandPoint.L&&SINA_WOOCALL_CONFIG.StandPoint.R){J.bn={L:SINA_WOOCALL_CONFIG.StandPoint.L,M:SINA_WOOCALL_CONFIG.StandPoint.M?SINA_WOOCALL_CONFIG.StandPoint.M:false,R:SINA_WOOCALL_CONFIG.StandPoint.R}}}};if(typeof Util=='undefined')Util={};Util.dC=(navigator.appName.indexOf("Microsoft",0)!=-1)?true:false;Util.dq=function(){var aa=Util.dp();return aa.H;};Util.dp=function(){var aa={};if(window.innerWidth){aa.W=window.innerWidth;aa.H=window.innerHeight;}else if(document.documentElement&&document.documentElement.clientWidth){aa.W=document.documentElement.clientWidth;aa.H=document.documentElement.clientHeight;}else if(document.body){aa.W=document.body.clientWidth;aa.H=document.body.clientHeight;}return aa;};Util.du=function(){var eV;if(typeof window.pageYOffset!='undefined'){eV=window.pageYOffset;}else if(typeof document.compatMode!='undefined'&&document.compatMode!='BackCompat'){eV=document.documentElement.scrollTop;}else if(typeof document.body!='undefined'){eV=document.body.scrollTop;}return eV;};Util.eP=function(fj,dm){var cD="ABCDEFGHIJKLMNOPQRSTUVWXTZabcdefghiklmnopqrstuvwxyz";var cR=cD+"0123456789";var eQ='';for(var i=0;i<fj;i++){if(dm&&i==0){var eR=Math.floor(Math.random()*cD.length);eQ+=cD.substring(eR,eR+1);}else{var eR=Math.floor(Math.random()*cR.length);eQ+=cR.substring(eR,eR+1);}}return eQ;};Util.eX=function(name,value,di,eL,domain,eW){var cX=name+"="+escape(value)+((di)?"; di="+di.toGMTString():"")+((eL)?"; eL="+eL:"")+((domain)?"; domain="+domain:"")+((eW)?"; eW":"");document.cookie=cX;};Util.dr=function(name){var dc=document.cookie;var prefix=name+"=";var cJ=dc.indexOf("; "+prefix);if(cJ==-1){cJ=dc.indexOf(prefix);if(cJ!=0)return null;}else cJ+=2;var dg=document.cookie.indexOf(";",cJ);if(dg==-1)dg=dc.length;return unescape(dc.substring(cJ+prefix.length,dg));};function woocall_swf_file_DoFSCommand(cU,cE){switch(cU){case 'setUserNumber':S_WC.bA.fa(cE);break;case 'setTitle':S_WC.bA.eY(cE);break;}};if(Util.dC){document.write('<SCRIPT event=FSCommand(cU,cE) for='+S_WC.MyConf.A.bs+'>');document.write('woocall_swf_file_DoFSCommand(cU, cE);');document.write('</SCRIPT>');}S_WC.bA=function(){this.Init.apply(this,arguments);};S_WC.bA.eY=function(aD){if(!Util.dC)return;if($S.S_WC.aT.style.display!='none'){if(aD.length>15)aD=aD.substr(0,14)+'..';$S.S_WC.bb.innerHTML=aD;}};S_WC.bA.fa=function(bF){$S.S_WC.bd.innerHTML='在线'+bF+'人';};S_WC.bA.prototype={I:null,df:null,bV:null,bZ:null,cp:true,Init:function(I){if(I.ae){this.I=I;if(this.I.bG)this.I.A.bu=this.I.A.bu+this.I.bG+'/';$S.S_WC={};this.bZ=this.I.aE;this.cp=Util.dC;}},ad:function(){if(this.I&&this.I.ae){this.cv();this.cr();this.cz();}},eZ:function(n,cO){if(!this.I||!this.I.ae)return;if(typeof cO=='string'){this.I.bw=cO;}var fn=this.I.bw+n+'/';this.I.bv={by:fn+'boxlogo.gif',as:fn+'boxmin.gif',F:fn+'boxclose.gif',ax:fn+'boxmax.gif',aS:fn+'boxresume.gif',S:fn+"wc_style.css",bj:fn+"siner.gif",aY:fn+"barlogo.gif",ba:fn+"barresume.gif",aU:fn+"barclose.gif"};},cz:function(){if($(this.bZ+this.I.U)){$(this.bZ+this.I.U).onmousedown=this.bQ(this);}},cc:function(et){return function(dh){var e=(window.event)?window.event:dh;e.cancelBubble=true;et.bY();};},bY:function(){if(this.aR){this.bK.style.left=this.aR.left+'px';if(Util.dC){this.bK.style.top=(Util.du()+this.aR.top)+'px';}else this.bK.style.top=this.aR.top+'px';$S.S_WC.X=this.aR.left;$S.S_WC.Y=this.aR.top;this.bN(this.aR.width,this.aR.height);this.bK.style.width=this.aR.width+'px';this.bK.style.height=this.aR.height+'px';this.aR=null;var eg=this.bW.childNodes[1].childNodes[1];eg.src=this.I.bv.ax;eg.title="最大化";eg.alt="最大化";}else{this.aR={};this.aR.left=parseInt(this.bK.style.left);if(Util.dC)this.aR.top=parseInt(this.bK.style.top)-Util.du();else this.aR.top=parseInt(this.bK.style.top);this.aR.width=this.bK.clientWidth;this.aR.height=this.bK.clientHeight;var aF=this.I.A.ay;this.bK.style.left=aF+'px';$S.S_WC.X=aF;$S.S_WC.Y=aF;if(Util.dC){this.bK.style.top=(Util.du()+aF)+'px';}else this.bK.style.top=aF+'px';var da=Util.dp();this.bN((da.W-2*aF),(da.H-2*aF));this.bK.style.width=(da.W-2*aF)+'px';this.bK.style.height=(da.H-2*aF)+'px';var eg=this.bW.childNodes[1].childNodes[1];eg.src=this.I.bv.aS;eg.title="还原";eg.alt="还原";}},bN:function(width,height){this.bU.style.height=(height-this.bW.clientHeight-this.bJ.clientHeight)+"px";this.bM.style.width=width+'px';if(this.I.ag){this.bU.style.width=(width-this.I.al.width)+'px';this.bS.style.height=(height-this.bW.clientHeight-this.bJ.clientHeight)+"px";this.bS.firstChild.height=(height-this.bW.clientHeight-this.bJ.clientHeight-this.I.al.av);}else this.bU.style.width=width+'px';if(Util.dC){this.bJ.style.width=width+"px";this.bW.style.width=width+"px";}},bQ:function(et){return function(dh){et.ca();};},ca:function(){this.bK.style.display='';this.bK.style.left='-5000px';this.aT.style.display='none';if(this.bS&&this.bS.innerHTML.length==0)this.bS.innerHTML="";if(!this.l){this.bX();this.l=true;}this.cu();var eN=this.co(this.I.A.aL);if(this.cp){this.bW.style.width=this.bK.clientWidth+'px';this.bJ.style.width=this.bK.clientWidth+'px';if($S.S_WC.X&&$S.S_WC.Y){this.bK.style.top=(Util.du()+$S.S_WC.Y)+"px";this.bK.style.left=$S.S_WC.X+"px";}else{this.bK.style.top=(Util.du()+eN.y)+"px";this.bK.style.left=eN.x+"px";}}else{if(!this.I.A.au){this.bK.style.top=($S.S_WC.Y?$S.S_WC.Y:eN.y)+"px";this.bK.style.left=($S.S_WC.X?$S.S_WC.X:eN.x)+"px";}else{var cy=this;setTimeout(function(){var eN=cy.co(cy.I.A.aL);cy.bK.style.top=($S.S_WC.Y?$S.S_WC.Y:eN.y)+"px";cy.bK.style.left=($S.S_WC.X?$S.S_WC.X:eN.x)+"px";},500);}}},bX:function(){var s=$C('script');s.src=this.I.O;s.type='text/javascript';document.body.appendChild(s);},cu:function(){var A=this.bK;if(this.I.ag){var aj=this.bS;}var K=this.bM;var ao=this.bU;var at=this.bW;var f=this.bJ;var aQ=new Util.dF(f,A);var Z=0;var az=at.clientHeight+f.clientHeight+this.I.A.az;if(this.I.ag){aQ.bi(this.I.A.aB+this.I.al.width,az,Z)}else aQ.bi(this.I.A.aB,az,Z);var cy=this;aQ.eI=function(){ao.style.visibility='hidden';};aQ.eJ=function(fr,cN){K.style.width=cN+"px";if(cy.I.ag){ao.style.width=(cN-cy.I.al.width)+"px";}else ao.style.width=cN+"px";if(Util.dC){f.style.width=cN+"px";at.style.width=cN+"px";}};aQ.eG=function(ft,cM){ao.style.height=(cM-at.clientHeight-f.clientHeight)+"px";K.style.height=(cM-at.clientHeight-f.clientHeight)+"px";if(cy.I.ag){aj.style.height=(cM-at.clientHeight-f.clientHeight)+"px";aj.firstChild.height=cM-at.clientHeight-f.clientHeight-cy.I.al.av;}};aQ.eH=function(){ao.style.visibility='';if(cy.I.ag){ao.style.width=(A.clientWidth-cy.I.al.width)+"px";K.style.width=A.clientWidth+"px";}else ao.style.width=A.clientWidth+"px";var am=(A.clientHeight-at.clientHeight-f.clientHeight);K.style.height=am+"px";if(cy.I.ag){aj.style.height=am+"px";aj.firstChild.height=am-cy.I.al.av;}ao.style.height=am+"px";};},cr:function(){var A=$C('div');var at=$C('div');var T=$C('div');var bx=$C('div');var K=$C('div');if(this.I.ag)var ah=$C('div');var ao=$C('div');var f=$C('div');document.body.appendChild(A);A.appendChild(at);A.appendChild(K);A.appendChild(f);at.appendChild(bx);at.appendChild(T);K.appendChild(ao);K.className='my_content';ao.className='Fla';ao.id=this.I.aE+this.I.ap;if(this.I.A.an){ao.style.width=this.I.A.bI+"px";ao.style.height=this.I.A.ar+"px";}if(this.I.ag){K.appendChild(ah);ah.id=this.I.aE+this.I.ai;ah.className='ExtPanel';ah.style.width=this.I.al.width+'px';ah.style.height=this.I.A.ar+'px';K.style.width=(this.I.A.bI+this.I.al.width)+'px';}K.style.height=this.I.A.ar+'px';at.className='Hnd';T.className='Ctrl';T.innerHTML='<img src="'+this.I.bv.as+'" height="36" width="14" alt="最小化" title="最小化" /><img src="'+this.I.bv.ax+'" height="36" width="14"  alt="最大化" title="最大化" /><img src="'+this.I.bv.F+'"  height="36" width="16" alt="关闭" title="关闭" />';this.cf(T);var aH=document.title;if(aH.length>this.I.aI){aH=aH.substr(0,this.I.aI)+'..';}var aJ='<img align="absmiddle" src="'+this.I.bv.by+'" /> '+aH;var fl='<div class="Title">'+aJ+'</div>';bx.innerHTML=fl;f.className='Bottom';var aP=$C('div');f.appendChild(aP);aP.className='Resize';this.cs(at,A);this.bK=A;this.bM=K;if(this.I.ag)this.bS=ah;this.bW=at;this.bU=ao;this.bJ=f;if(this.cp)this.cg();this.ck(A);this.ci();var cy=this;if(this.I.A.au){if(this.cp){this.Q.onreadystatechange=function(){if(this.readyState=='complete'){cy.ca();}};}else{this.ca();}}if(this.I.aW){if(this.cp){this.Q.onreadystatechange=function(){if(this.readyState=='complete'){if(cy.I.A.au)cy.ca();cy.cC();if(cy.I.bo){cy.bK.style.left="-5000px";}}};}else{if(cy.I.A.au)cy.ca();this.cC();if(cy.I.bo){cy.bK.style.left="-5000px";}}}},cg:function(){this.cw=window.onscroll;window.onscroll=this.cx(this);},cx:function(et){return function(){if(typeof et.cw=='function')et.cw();if(et.aT.display!='none'){et.aT.style.top=(Util.du()+Util.dq()-et.aT.offsetHeight)+"px";}if($S.S_WC.X&&$S.S_WC.Y){et.bK.style.top=(Util.du()+$S.S_WC.Y)+"px";}else{var eN=et.co(et.I.A.aL);et.bK.style.top=(Util.du()+eN.y)+"px";}};},ci:function(){ei=$C("link");ei.rel="stylesheet";ei.type="text/css";ei.href=this.I.bv.S;this.Q=ei;var head=document.getElementsByTagName("head")[0];head.appendChild(ei);},cf:function(g){var ek=g.childNodes[0];ek.onmousedown=this.bP(this);var eq=g.childNodes[1];eq.onmousedown=this.cc(this);var ee=g.childNodes[2];ee.onmousedown=this.bL(this);},bP:function(et){return function(dh){var e=(window.event)?window.event:dh;if(e){if(typeof e.layerY=='undefined')e.layerY=e.offsetY;if(e.layerY>50||e.layerY<-10)return;e.cancelBubble=true;var aw=this.parentNode.parentNode.parentNode;aw.style.left="-5000px";et.cC();}};},cs:function(dA,root){Util.ac.dB(dA,root,0,document.body.clientWidth,0);if(this.cp){root.eE=function(x,y){this.children[1].style.visibility='hidden';};root.eD=function(x,y){this.children[1].style.visibility='visible';$S.S_WC.X=x;$S.S_WC.Y=y-Util.du();};}else{root.eD=function(x,y){$S.S_WC.X=x;$S.S_WC.Y=y};}},ck:function(g){g.className=this.bZ+this.I.B;if(this.I.ag){g.style.width=(this.I.A.bI+this.I.al.width)+'px';}else g.style.width=this.I.A.bI+"px";if(this.cp)g.style.position="absolute";else g.style.position="fixed";g.style.zIndex=100;g.style.display='none';},co:function(aM){var eT={};switch(aM.toLowerCase()){case 'middle':eT.x=(document.body.clientWidth-this.bK.clientWidth)/2;if(this.cp)eT.y=(Util.dq()-this.bK.clientHeight)/2;else eT.y=(Util.dq()-this.bK.clientHeight)/2;break;case 'rightbottom':eT.x=document.body.clientWidth-this.bK.clientWidth-10;if(this.cp)eT.y=Util.dq()-this.bK.clientHeight;else eT.y=Util.dq()-this.bK.clientHeight;break;case 'lefttop':eT.x=2;eT.y=2;break;case 'leftbottom':eT.x=2;if(this.cp)eT.y=Util.dq()-this.bK.clientHeight;else eT.y=Util.dq()-this.bK.clientHeight;break;case 'righttop':eT.x=document.body.clientWidth-this.bK.clientWidth-10;eT.y=2;break;default:var cF=aM.split(':');eT.x=parseInt(cF[0]);eT.y=parseInt(cF[1]);break;}return eT;},cv:function(){var ec=$C('div');document.body.appendChild(ec);if(this.cp)ec.style.position='absolute';else ec.style.position='fixed';ec.style.zIndex=99;ec.className=this.I.aE+'_SBar';if(this.I.aZ.toLowerCase()=='r'){ec.style.left=(document.body.clientWidth-this.I.bf-10)+'px';}else if(this.I.aZ.toLowerCase()=='l'){ec.style.left=10+'px';}else ec.style.left=(document.body.clientWidth-this.I.bf-10)+'px';ec.style.top=(Util.dq()-this.I.aV)+'px';ec.style.display='none';if(this.I.bv.bc){var er=$C('div');er.innerHTML='<img src="'+this.I.bv.bc+'" />';ec.appendChild(er);}var ej=$C('div');ej.className='mbody';ec.appendChild(ej);var ed=$C('div');ed.className='bartext';ed.innerHTML='<span class="weltxt">'+this.I.be+'</span>';ed.onmousedown=this.bQ(this);ej.appendChild(ed);var eh=$C('div');eh.className='infobar';eh.innerHTML='<span class="barlogoblk"><img src="'+this.I.bv.aY+'" align="absmiddle"/></span><span class="ctrlimg"><img src="'+this.I.bv.ba+'" align="absmiddle" title="显示聊天窗口" alt="显示聊天窗口"/><img src="'+this.I.bv.aU+'" align="absmiddle" title="关闭" alt="关闭"/></span><span class="olusr"> </span>';ej.appendChild(eh);var el=eh.childNodes[1].childNodes[0];el.onmousedown=this.bQ(this);var es=eh.childNodes[1].childNodes[1];es.onmousedown=this.bL(this);$S.S_WC.aT=this.aT=ec;$S.S_WC.bb=ed;$S.S_WC.bd=eh.childNodes[2];var cy=this;window.onresize=function(){cy.cl();};},cC:function(){this.aT.style.display='';var eu=0;if(this.I.bv.bc){eu=1;}this.aT.childNodes[eu].childNodes[0].innerHTML='<span class="weltxt">'+this.I.be+'</span>';if(this.cp){this.aT.style.top=(Util.du()+Util.dq()-this.aT.offsetHeight)+"px";}},cl:function(){if(this.I.aZ.toLowerCase()=='r'){this.aT.style.left=(document.body.clientWidth-this.I.bf-10)+'px';}else if(this.I.aZ.toLowerCase()=='l'){this.aT.style.left=10+'px';}else this.aT.style.left=(document.body.clientWidth-this.I.bf-10)+'px';this.aT.style.top=(Util.dq()-this.aT.offsetHeight)+'px';},bL:function(et){return function(dh){var e=(window.event)?window.event:dh;e.cancelBubble=true;if(et.aT.style.display!='none'){et.bU.innerHTML='';et.aT.style.display='none';et.bK.style.display='none';}else{if(confirm("确认要关闭Woocall吗？刷新页面可重新显示")){et.bU.innerHTML='';et.aT.style.display='none';et.bK.style.display='none';}}};}};function S_WC_Creese(){if(arguments.callee.db)return;arguments.callee.db=true;S_WC.MyConf.ag=false;S_WC.MyConf.bG='0_2_REV1';LdPgCfg(S_WC.MyConf);var bH=new S_WC.bA(S_WC.MyConf);bH.eZ('Grey2');bH.ad();}; 

var __SafeMode = false;
if(typeof SINA_WOOCALL_CONFIG != 'undefined' && SINA_WOOCALL_CONFIG.SafeMode)
	__SafeMode = true;	


function DOMLoad(e,el)
{
 	if(DOMLoad.intiateOnce){return;};
		if(  el && el.runtimeStyle )
		{
			//IE5.0+
			var rState = false
			if(!__SafeMode){
				rState = (document.readyState.toLowerCase()=="complete" ||	
				document.readyState.toLowerCase()=="interactive");
			}
			else{
				rState = (document.readyState.toLowerCase()=="complete");
			}
			if(rState)
			{
				el.runtimeStyle.behavior = "none";
				S_WC_Creese();
			}
			else
			{
				return false;
			};
		}
 	DOMLoad.intiateOnce = true;
};

if (document.addEventListener) {
    document.addEventListener("DOMContentLoaded", S_WC_Creese, false);
}


/*@cc_on @*/
/*@if (@_win32)
	if(!__SafeMode){
		document.write("<script id=__ie_onload defer src=javascript:void(0)><\/script>");
		var __script = document.getElementById("__ie_onload");
		__script.onreadystatechange = function() 
		{    
			if (this.readyState == "complete") 
			{        
				S_WC_Creese(); // call the onload handler    
			}
		};	
	}
/*@end @*/

var ___oldonload = window.onload;
		
if (typeof window.onload != 'function') {
	window.onload = S_WC_Creese;
} else {
	window.onload = function() {
		___oldonload();
		S_WC_Creese();
	}
}


