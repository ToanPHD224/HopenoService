<%@ include file="/WEB-INF/views/common/jstl.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<c:url value="/resources" var="cssroot" />
                <div class="row">    
              <div  class="col-sm-12 ">
                <div class="row d-flex justify-content-center">
              <div  class="card mt-5" >
                <div class="card-header">
                  <h2> <i class="fas fa-plus"></i> <strong>Thêm thể loại dịch vụ</strong> </h2>
                </div>
                <div  class="card-body">
                  <div class="card card-light">
                      <div class="card-header">
                        <h3 class="card-title">Đơn đăng Kí</h3>
                      </div>
                      <!-- /.card-header -->
                      <!-- form start -->
                      <form action="/admin/addservicetype" method="POST" enctype="multipart/form-data" >
                        <div class="card-body">
                          <div class="form-group">
                            <label for="nameoftype">Tên thể loại</label>
                            <input type="text" class="form-control" name="name" placeholder="Enter  Name">
                          </div>
                          <div class="form-group">
                            <label for="exampleInputPassword1">Phí đặt sân (%)</label>
                            <input type="number" class="form-control" name="bookfee" placeholder="Enter Book Fee">
                          </div>
                          <div class="form-group">
                            <label for="exampleInputFile">Hình ảnh</label>
                            <div class="input-group">
                              <div class="custom-file">
                                <input type="file" class="custom-file-input" name="file" id="exampleInputFile">
                                <label class="custom-file-label"  for="exampleInputFile">Chọn file</label>
                              </div>
                              <div class="input-group-append">
                                <span class="input-group-text" id="">Upload</span>
                              </div>
                            </div>
                          </div>
                        </div>
                        <!-- /.card-body -->
        
                        <div class="card-footer">
                          <button type="submit" style="border: 1px solid black;" name="action" value="save" class="btn"> <i class="fas fa-plus"></i>&nbspLưu</button>
                          <button type="submit" style="border: 1px solid black;" name="action" value="cancle" class="btn"><i class="far fa-window-close"></i>&nbspHủy</button>
                        </div>
                      </form>
                    </div>
                </div>
                <div class="card-footer">

                </div>
            </div>
          </div>
        </div>
                </div>

<script>

</script>