
function checkArticleInfos() {
	var f = document.articleInfoForm;

	//f.subject.value = trim(f.subject.value);
	//alert(f.subject.value );
	if( isEmpty(f.subject.value) ) {
		alert("���������!");
		f.subject.focus();
		return false;
	} else	if( f.subject.value.length > 50 ) {
		alert("������������ܳ���50���ַ�!");
		f.subject.focus();
		return false;
	}
	//alert(f.body.value);
	if( isEmpty(f.body.value) ) {
		alert("����������!");
		//f.body.focus();
		return false;
	} else	if( f.body.value.length > 20000 ) {
		alert("���ݹ��������ܳ���20000���ַ�!");
		//f.body.focus();
		return false;
	}
	if(!isPosInteger(f.divs_putKey.value)){ 
		alert("��֤���������");
		return false;
	}
	return true;
}

function checkArticleInfo() {
	var f = document.articleInfoForm;

	//f.subject.value = trim(f.subject.value);
	//alert(f.subject.value );
	if( isEmpty(f.subject.value) ) {
		alert("���������!");
		f.subject.focus();
		return false;
	} else	if( f.subject.value.length > 50 ) {
		alert("������������ܳ���50���ַ�!");
		f.subject.focus();
		return false;
	}
	//alert(f.body.value);
	if( isEmpty(f.body.value) ) {
		alert("����������!");
		//f.body.focus();
		return false;
	} else	if( f.body.value.length > 20000 ) {
		alert("���ݹ��������ܳ���20000���ַ�!");
		//f.body.focus();
		return false;
	}
	return true;
}

function checkBoardIdInfo() {
	var f = document.boardIdInfoForm;

	//f.newBoardId.value = trim(f.newBoardId.value);
	if( isEmpty(f.newBoardId.value) ) {
		alert("�������ID!");
		f.newBoardId.focus();
		return false;
	} else	if( f.newBoardId.value.length > 15 ) {
		alert("��ID���������ܳ���15���ַ�!");
		f.newBoardId.focus();
		return false;
	}
	return true;
}

function htmlA()
{
	var location = prompt("���������ӵĵ�ַ��","http://");
	if(location == null)	return;
	var info = prompt("���������ӵ�˵�����֣�","");
	if(info == null)	return;
		articleInfoForm.body.value=articleInfoForm.body.value+"<a target=\"_blank\" href=\""+location+"\">"+info+"</a>";
}
function htmlIMG()
{
	var location = prompt("������ͼƬ�ĵ�ַ��","http://");
	if(location == null)	return;
	var info = prompt("������ͼƬ��˵�����֣�","");
	if(info == null)	return;
	articleInfoForm.body.value=articleInfoForm.body.value+"<img src=\""+location+"\" alt=\""+info+"\">";
}
function htmlFONT()
{
	var content = prompt("���������ֵ����ݣ�","");
	if(content == null)	return;
	var color = prompt("���������ֵ���ɫ(RRGGBB)�� (���ɫΪred��ff0000)","");
	if(color == null)	return;
	var size = prompt("���������ֵĳߴ�(0-4)","4");
	if(size == null) return;
	var b = confirm("�Ƿ��ô����֣�");
	if(b == null) return;
	if(size < 0) size=0;
	if(size > 4) size=4;
	if(b)
		articleInfoForm.body.value=articleInfoForm.body.value+"<font color=\""+color+"\" size=\""+size+"\"><b>"+content+"</b></font>";
	else
		articleInfoForm.body.value=articleInfoForm.body.value+"<font color=\""+color+"\" size=\""+size+"\">"+content+"</font>";
}

function reimgSize()
{
    for (i=0;i<document.images.length;i++)
    {
        if(document.images[i].width>634)
        {
            document.images[i].width=634;
        }
    }
}
