var b=window.gadgets;if(!b)INFO("gadgets.* not found.");var f=window.opensocial;if(!b)INFO("opensocial.* not found.");var j={};window.flashAPI=j;j.VERSON=0.7;j.DEFAULT_FLASH_ID="flashObj";j.isAPIReady=function(a){
    try{
        if(!j.swfObj)j.swfObj=j.thisFlash(a);return j.swfObj?true:false
        }catch(d){
        INFO(d);return false
        }
    };j.embedFlash=function(a,d,c,e,g){
    var h=document.getElementById(d);if(!h)return false;var i=c.match(/(\d+)(?=[\.,]?)/g),m=i!=null?Number(i[0]):9;EXPORT("currentVer",b.flash.getMajorVersion());
    EXPORT("expectVer",m);if(b.flash.getMajorVersion()<m){
        g=g||'<span style="font-size:small;color:#777;"> Please install or upgrade to <a href="http://www.adobe.com/cn/products/flashplayer/" style="color:#36C;" target="_blank">Flash Player 9.0</a>.</span>';h.innerHTML=g;return false
        }var l="";e=e||{};if(navigator.plugins&&navigator.mimeTypes&&navigator.mimeTypes.length){
        l='<embed src="'+a+'" id="'+j.DEFAULT_FLASH_ID+'" name="'+j.DEFAULT_FLASH_ID+'" type="application/x-shockwave-flash"';for(var k in e)l+=
            k+'="'+e[k]+'" ';l+="/>"
        }else{
        l='<object id="'+j.DEFAULT_FLASH_ID+'" classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000"';var n='<param name="movie" value="'+a+'" />';for(var k in e)if(k=="width"||k=="height")l+=" "+k+'="'+e[k]+'"';else n+='<param name="'+k+'" value="'+e[k]+'" />';l+=">"+n+"</object>"
        }h.innerHTML=l;return true
    };j.getEnvironment=function(){
    var a={};if(f.getEnvironment){
        var d=f.getEnvironment();a.domain=d.getDomain()
        }else a.domain=j.extractDomain(document.referrer);a.view="profile";
    if(b)if(b.views)a.view=b.views.getCurrentView().getName();EXPORT("env",a);return a
    };j.setStageWidth=function(a){
    if(j.swfObj.width!=a)j.swfObj.width=a
        };j.setStageHeight=function(a){
    if(j.swfObj.height!=a){
        j.swfObj.height=a;if(b&&b.window&&b.window.adjustHeight)b.window.adjustHeight(a)
            }
    };j.fetchBasicData=function(a,d,c){
    EXPORT("params_",c);c=j.wrapParams(c,f.DataRequest.PeopleRequestFields);var e=f.newDataRequest();e.add(e.newFetchPersonRequest("OWNER",j.cloneObject(c)),"o");e.add(e.newFetchPersonRequest("VIEWER",
        j.cloneObject(c)),"v");e.add(e.newFetchPeopleRequest("OWNER_FRIENDS",j.cloneObject(c)),"of");e.add(e.newFetchPeopleRequest("VIEWER_FRIENDS",j.cloneObject(c)),"vf");e.send(function(g){
        try{
            EXPORT("raw",g);var h=new j.BasicData(g);EXPORT("basic_",h);j.swfObj.handleFetchBasicData(a,b.json.stringify(h))
            }catch(i){
            j.swfObj.handleError(a,i)
            }
        })
    };j.fetchPeople=function(a,d,c){
    c=j.wrapParams(c,f.DataRequest.PeopleRequestFields);var e=f.newDataRequest();e.add(e.newFetchPeopleRequest(d,c),"f");e.send(function(g){
        try{
            var h=
            j.getPeople(g,"f");j.swfObj.handleFetchPeople(a,b.json.stringify(h))
            }catch(i){
            j.swfObj.handleError(a,i)
            }
        })
    };j.fetchPerson=function(a,d,c){
    c=j.wrapParams(c,f.DataRequest.PeopleRequestFields);var e=f.newDataRequest();e.add(e.newFetchPersonRequest(d,c),"p");e.send(function(g){
        try{
            var h=j.getPerson(g,"p");j.swfObj.handleFetchPerson(a,b.json.stringify(h))
            }catch(i){
            j.swfObj.handleError(a,i)
            }
        })
    };j.fetchPersonFriends=function(a,d,c){
    c=j.wrapParams(c,f.DataRequest.PeopleRequestFields);var e=f.newDataRequest();
    e.add(e.newFetchPersonRequest(d,j.cloneObject(c)),"p");e.add(e.newFetchPeopleRequest(d,j.cloneObject(c)),"f");e.send(function(g){
        try{
            var h=j.getPerson(g,"p"),i=j.getPeople(g,"f");j.swfObj.handleFetchPersonFriends(a,b.json.stringify(h),b.json.stringify(i))
            }catch(m){
            j.swfObj.handleError(a,m)
            }
        })
    };j.fetchPersonAppData=function(a,d,c){
    var e=f.newDataRequest();e.add(e.newFetchPersonAppDataRequest(d,c),"d");e.send(function(g){
        try{
            var h=j.getData(g,"d");j.swfObj.handleFetchPersonAppData(a,b.json.stringify(h))
            }catch(i){
            j.swfObj.handleError(a,
                i)
            }
        })
    };j.updatePersonAppData=function(a,d,c,e){
    var g=f.newDataRequest();g.add(g.newUpdatePersonAppDataRequest(d,c,e));g.send(function(){
        j.swfObj.handleUpdatePersonAppData(a)
        })
    };j.fetchActivities=function(a,d,c){
    c=j.wrapParams(c,f.DataRequest.ActivityRequestFields);var e=f.newDataRequest();e.add(e.newFetchActivitiesRequest(d,c),"a");e.send(function(g){
        try{
            var h=j.getActivities(g,"a");j.swfObj.handleFetchActivities(a,b.json.stringify(h))
            }catch(i){
            j.swfObj.handleError(a,i)
            }
        })
    };j.createActivity=function(a,
    d,c){
    d=j.wrapParams(d,f.DataRequest.ActivityRequestFields);var e=f.newActivity(d);f.requestCreateActivity(e,c,function(){
        j.swfObj.handleCreateActivity(a)
        })
    };j.BasicData=function(a){
    this.viewer=j.getPerson(a,"v");this.viewerData=j.getPersonAppData(a,"vd","VIEWER");this.viewerFriends=j.getPeople(a,"vf");this.owner=j.getPerson(a,"o");this.ownerData=j.getPersonAppData(a,"od","OWNER");this.ownerFriends=j.getPeople(a,"of")
    };j.Collection=function(a,d){
    this.array=[];this.totalSize=0;this.size=0;this.offset=
    0;if(!a)return;var c=null;if(a.asArray){
        c=a.asArray();this.offset=a.getOffset();this.totalSize=a.getTotalSize();this.size=a.size()
        }else if(j.isArray(a)){
        c=a;this.offset=0;this.totalSize=a.length;this.size=this.totalSize
        }if(c!=null)for(var e in c)this.array.push(new d(c[e]))
        };j.Person=function(a){
    if(!a)return;this.isOwner=a.isOwner();this.isViewer=a.isViewer();this.displayName=a.getDisplayName();this.id=a.getId();this.fields={};j.wrapFields(a,this)
    };j.Activity=function(a){
    if(!a)return;this.id=a.getId();
    this.fields={};j.wrapFields(a,this)
    };j.Message=function(a){
    if(!a)return;this.fields={};j.wrapFields(a,this)
    };j.SimpleType=function(a){
    this.fields={};if(a!=null)j.wrapFields(a,this)
        };j.getData=function(a,d){
    if(!a)return null;if(a.hadError())console.info("[ERROR] Data Response Error!");if(!d)return null;var c=a.get(d);if(!c)return null;if(c.hadError())console.info("[ERROR] "+c.getErrorCode()+":"+c.getErrorMessage());return c.getData()
    };j.getPerson=function(a,d){
    var c=j.getData(a,d);if(d=="v")EXPORT("viewer",
        c);else if(d=="o")EXPORT("owner",c);if(!c)return null;var e=new j.Person(c);return e
    };j.getPeople=function(a,d){
    var c=j.getData(a,d);if(!c)return null;var e=new j.Collection(c,j.Person);return e
    };j.getPersonAppData=function(a,d,c){
    var e=j.getData(a,d);if(!e)return null;if(c=="VIEWER"||c=="OWNER")for(var g in e)return e[g];else if(c!=null)return e[c];return null
    };j.getActivities=function(a,d){
    var c=j.getData(a,d);if(!c)return null;var e=new j.Collection(c,j.Activity);return e
    };j.checkType=function(a){
    var d=
    null;if(f.Address&&a instanceof f.Address)d=f.Address;else if(f.Email&&a instanceof f.Email)d=f.Email;else if(f.Name&&a instanceof f.Name)d=f.Name;else if(f.Organization&&a instanceof f.Organization)d=f.Organization;else if(f.Phone&&a instanceof f.Phone)d=f.Phone;else if(f.Url&&a instanceof f.Url)d=f.Url;else if(f.Person&&a instanceof f.Person)d=f.Person;else if(f.Activity&&a instanceof f.Activity)d=f.Activity;else if(f.Message&&a instanceof f.Message)d=f.Message;else if(f.Enum&&a instanceof f.Enum)d=
        f.Enum;return d
    };j.wrapFields=function(a,d){
    if(a==null)return null;var c=j.checkType(a);if(c==null)return a;else if(c==f.Enum)return a.getDisplayValue();d=d||new j.SimpleType(null);d.fields=d.fields||{};for(var e in c.Field){
        var g=c.Field[e],h=a.getField(g);if(h!=null)if(j.isArray(h)){
            d.fields[e]=[];j.forEach(h,function(i){
                d.fields[e].push(j.wrapFields(i))
                })
            }else d.fields[e]=j.wrapFields(h)
            }return d||{}
    };j.wrapParams=function(a,d){
    if(!d||!a)return null;var c={};for(var e in a)switch(e){
        case "PROFILE_DETAILS":var g=
            a[e];if(g!=null){
                var h=[];for(var i=0;i<g.length;++i)h.push(f.Person.Field[g[i]]);c[d[e]]=h
                }break;case "FILTER":c[d[e]]=f.DataRequest.FilterType[a[e]];break;case "SORT_ORDER":c[d[e]]=f.DataRequest.SortOrder[a[e]];break;default:c[d[e]]=a[e];break
            }return c
    };j.isArray=function(a){
    if(!a)return false;return Array?a instanceof Array:(typeof a=="object"&&typeof a.length=="number"&&typeof a.splice!="undefined"?true:false)
    };j.forEach=function(a,d,c){
    var e=a.length;for(var g=0;g<e;g++)if(g in a)d.call(c,a[g],
        g,a)
    };j.extractDomain=function(a){
    var d=/(\w+):\/\/([\w.]+)\/(\S*)/,c=a.match(d);return c!=null?c[2]:""
    };j.cloneObject=function(a){
    if(a==null)return null;switch(typeof a){
        case "function":return a;case "object":var d=new a.constructor;for(var c in a)d[c]=j.cloneObject(a[c]);return d;default:return a.valueOf()
            }
    };j.thisFlash=function(a){
    a=a||j.DEFAULT_FLASH_ID;return navigator.appName.indexOf("Microsoft")!=-1?document[a]:document.getElementById(a)
    };j.debugInspect=function(a,d,c){
    if(!c)c="\n";if(!d)d=
        "";if(a==null)return c||"";for(var e in a){
        c+=d+e+"["+typeof a[e]+"] : "+a[e]+"\n";if(typeof a[e]=="object")c=j.debugInspect(a[e],d+"\t",c)
            }return c||""
    };j.debugExport=function(a,d){
    window.debug=window.debug||{};window.debug[a]=d
    };j.debugInfo=function(a){
    console.info(a)
    };window.INFO=j.debugInfo;window.INSPECT=j.debugInspect;window.EXPORT=j.debugExport;