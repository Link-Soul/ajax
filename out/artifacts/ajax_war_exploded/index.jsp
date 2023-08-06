<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
</head>
<body>
insert<br/>
<form action="/ajax_war_exploded/insert" method="post">
  bookname<input type="text" id="booknameInsert" name="booknameInsert"><span id="insertSpan"></span>
  <button type="button" id="insertSubmit">submit</button>
  <button type="submit" id="submit" hidden="hidden">submit</button>
</form>
<hr/>
delete
<form action="/ajax_war_exploded/delete" method="post">
  bookname<input type="text" id="booknameDelete" name="booknameDelete">
  <button type="submit" >submit</button>

</form>
<hr/>
update
<form action="/ajax_war_exploded/update" method="post">
  bookname<input type="text" id="booknameUpdate" name="booknameUpdate">
  status<input type="text" id="statusUpdate" name="statusUpdate">
  <button type="submit" >submit</button>

</form>
<hr/>
select
<form action="/ajax_war_exploded/select" method="post">
  bookname<input type="text" id="booknameSelect" name="booknameSelect">
  <button type="submit" >submit</button>
</form>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
  var ifSubmit=false
  $("#booknameInsert").change(function (){
    var insert = $("#booknameInsert").val();
    $.ajax({
      url:'checkBookName',
      type:'get',
      data:{"bookname":insert},
      dataType:'json',
      success:function (data){

        if(data.result>0){
          $("#insertSpan").html("<span style='color: red'>book exist</span>")
          ifSubmit=true

        }else {
          $("#insertSpan").html("<span style='color: green'>OK</span>")
        }
      }
    })

  })
  $("#insertSubmit").click(function (){
    if (ifSubmit){
      $("#submit").click()
      console.log("11111111")
    }{
      alert("book exist")
    }
  })

</script>
</body>
</html>