
    $.ajax({
        type : "post",
        url : "/CU/getSession",
        dataType : "text",
        success : function(result) {
            let parse = JSON.parse(result);
            document.getElementById("b2").innerText=parse.kuser;
            document.getElementById("b3").innerText=parse.kuser;
            document.getElementById("b4").innerText=parse.kphone;
            // document.getElementById("#").innerText=parse.kid;
            // document.getElementById("#").innerText=parse.kdate;
            // document.getElementById("#").innerText=parse.kpassword;
        },
        error : function() {
            // alert("請求失敗");
            console.log("请求失败");
        }
    });