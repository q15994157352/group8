var kid="";

$(function() {
    $.ajax({
        type : "post",
        url : "/CU/getSession?date="+new Date(),
        dataType : "text",
        success : function(result) {
            let parse = JSON.parse(result);
            document.getElementById("b").innerText=parse.kuser;
          kid=parse.kid;
            document.getElementById("lione").style.display="block";
            document.getElementById("litwo").style.display="none";
            document.getElementById("lithree").style.display="block";
            document.getElementById("b2").innerText=parse.kuser;
        },
        error : function() {
            // alert("請求失敗");
            console.log("请求失败");
        }
    });
});
$(function() {
    $.ajax({
        type : "post",
        url : "/CU/getSession",
        dataType : "text",
        success : function(result) {
            let parse = JSON.parse(result);
            //document.getElementById("b").innerText=parse.kuser;
            kid=parse.kid;
            //document.getElementById("lione").style.display="block";
           // document.getElementById("litwo").style.display="none";
            // hashMap.put( "bm_totalmoney",bm_totalmoney);
            // hashMap.put( "rt_repayment",rt_repayment );
            //hashMap.put( "surplus",surplus );
            //document.getElementById("lithree").style.display="block";
            document.getElementById("a1").innerText=parse.bm_totalmoney;
            document.getElementById("a2").innerText=parse.rt_repayment;
            document.getElementById("a3").innerText=parse.surplus;
            document.getElementById("a4").innerText=parse.balance;
        },
        error : function() {
            // alert("請求失敗");
            console.log("请求失败");
        }
    });
});

$(function () {
    $("#logOut").click(function () {
        $.ajax({
            url:"/CU/loginOut",
            type:"get",
            dataType:"JSON",
            success:function (response) {
                if (response==1){
                    Location.href="index.html";
                }
            },
            error:function () {
                console.log("请求失败");
            }
        })
    })
});
