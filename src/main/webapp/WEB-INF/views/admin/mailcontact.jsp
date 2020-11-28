<%@ include file="/WEB-INF/views/common/jstl.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<c:url value="/resources" var="cssroot" />
<div class="row justify-content-center">
  <form action="/admin/contact" method="POST">
  <div class="col-sm-12">
  <div class="card card-primary card-outline">
    <div class="card-header">
     <div class="row">
      <h3 class="card-title">Compose New Message</h3>
     </div>
     <div class="row">
      <p class="card-title" >${message}</p>

     </div>
          </div>
    <!-- /.card-header -->
    <div class="card-body">
      
        <div class="form-group">
          <input class="form-control" placeholder="To:" name="mail" value="${mail}">
        </div>
        <div class="form-group">
          <input class="form-control" placeholder="Subject:" name="subject">
        </div>
        <div class="form-group">
          <textarea id="summernote" name="editordata">

            Summernote cung cấp cho chúng ta thêm 
            các callback function sẽ chạy phụ thuộc vào các trạng thái, 
            các sự kiện của editor như onInit, onEnter, onFocus, onFocus, onBlur, onKeyup, onPaste, onImageUpload,.... 
            Dưới đây là ví dụ về 2 cách sử dụng callback onFocus:


          </textarea>
       
        </div>
    </div>
    <!-- /.card-body -->
    <div class="card-footer">
      <div class="float-right">
        <button type="submit" class="btn btn-primary" name="action" value="send" >   <i class="far fa-envelope"></i> Send</button>
      </div>
      <button type="submit" id="discard" class="btn btn-default" name="action" value="cancle" > <i class="fas fa-times"></i> Discard</button>
    </div>
    <!-- /.card-footer -->
  </div>
</div>
  </form>
</div>
<script>

  $(function () {
    //Add text editor
    $('#summernote').summernote()
  })

</script>