function btn(){
	 var id = document.querySelector('#id');
	var pw = document.querySelector('#pw');
	var email = document.querySelector('email');


		if (id.value == "" || pw.value == ""){
			if(pw.value == "" !== pw_r.value ==""){
			alert("fail")
			}else{
				alert("Ok")
			}
		}else{
			alert("not acaount")
		}
	}
	


	/* function sumbitWriteForm(form) {
		form.titel.value = form.title.value.trim();
		if(value.length == 0){
			alert("正しく入力してください。");
			form.title.focus();
			retrun false;
		}
		form.submit();
	} */