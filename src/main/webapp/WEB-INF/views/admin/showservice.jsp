<style>
    #btnh:hover{
        background-color:green;
        opacity: 0.8;
    }
</style>
<div class="row">
    <div class="col-sm-12">
        <div class="card mt-3">
            <div class="card-header">
                <h3 class="card-title">Service</h3>
            </div>
            <!-- /.card-header -->
            <div class="card-body">
               
                <div id="example2_wrapper" class="dataTables_wrapper dt-bootstrap4">
                    <div class="row">
                        
                        <div class="col-sm-12 col-md-8"></div>
                        <div class="col-sm-12 col-md-4">  
                            <div class="card-tools">
                                <div class="input-group input-group-sm">
                                  <input type="text"  class="form-control" id="values" placeholder="Search Service">
                                  <div class="input-group-append">
                                    <div class="btn btn-primary" id="service">
                                      <i class="fas fa-search"></i>
                                    </div>
                                  </div>
                                </div>
                              </div>
                        </div>   
                            
                    </div>
                    <div class="row">
                        <div class="col-sm-12">
                            <table id="example2" class="table table-bordered table-hover dataTable dtr-inline"
                                role="grid" aria-describedby="example2_info">
                                <thead>
                                    <tr role="row">
                                        <th class="sorting_asc" tabindex="0" aria-controls="example2" rowspan="1"
                                            colspan="1"
                                            aria-label="Rendering engine: activate to sort column descending"
                                            aria-sort="ascending">Service Name</th>
                                        <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1"
                                            colspan="1" aria-label="Browser: activate to sort column ascending">Address
                                        </th>
                                        <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1"
                                            colspan="1" aria-label="Platform(s): activate to sort column ascending">
                                            Distric</th>
                                        <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1"
                                            colspan="1" aria-label="Engine version: activate to sort column ascending">
                                            Account id</th>
                                        <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1"
                                            colspan="1" aria-label="CSS grade: activate to sort column ascending">
                                            Createdat</th>
                                        <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1"
                                            colspan="1" aria-label="CSS grade: activate to sort column ascending">
                                            Image</th>
                                            <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1"
                                            colspan="1" aria-label="CSS grade: activate to sort column ascending">
                                            Status</th>
                                            <th></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr role="row" class="odd">
                                        <td tabindex="0" class="sorting_1">Service Name</td>
                                        <td>Service</td>
                                        <td>Win 98+ / OSX.2+</td>
                                        <td>1.7</td>
                                        <td>A</td>
                                        <td>A</td>
                                        <td>Ok</td>
                                        <td>
                                            <button id="btnh" class="btn"><i class="fas fa-ban"></i> Disable </button>
                                        </td>
                                    </tr>
                                   
                                </tbody>
                                <tfoot>
                                    <tr>
                                        <th rowspan="1" colspan="1">Service Name</th>
                                        <th rowspan="1" colspan="1">Service Type</th>
                                        <th rowspan="1" colspan="1">Total Book</th>
                                        <th rowspan="1" colspan="1">Toltal Pay</th>
                                        <th rowspan="1" colspan="1">Total Fee</th>
                                        <th rowspan="1" colspan="1">Month</th>
                                        <th rowspan="1" colspan="1">Status</th>
                                        <th rowspan="1" colspan="1"></th>
                                    </tr>
                                </tfoot>
                            </table>
                        </div>
                    </div>
                  
                </div>
            </div>
            <!-- /.card-body -->
        </div>
    </div>
</div>
<script>
    $(function () {
        $("#example1").DataTable({
            "responsive": true,
            "autoWidth": false,
        });
        $('#example2').DataTable({
            "paging": true,
            "lengthChange": false,
            "searching": false,
            "ordering": true,
            "info": true,
            "autoWidth": false,
            "responsive": true,
        });
    });
    $("#service").click(function () {
		var service = $("#values").val();
		$.ajax({
			url: "http://localhost:8090/admin/registerform",
			data: {
				name: service
			}

		});

	});
</script>