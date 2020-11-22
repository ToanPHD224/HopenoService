<div class="row">
    <div class="col-sm-12">
        <div class="card mt-3">
            <div class="card-header">
                <h3 class="card-title">Service Payment</h3>
            </div>
            <!-- /.card-header -->
            <div class="card-body">
               
                <div id="example2_wrapper" class="dataTables_wrapper dt-bootstrap4">
                    <div class="row">
                        
                        <div class="col-sm-12 col-md-8">  <button class="btn"><i class="fas fa-bell"></i> SendBill </button> </div>
                        <div class="col-sm-12 col-md-4">
                            <div class="row">
                                <div class="col-sm-2 mt-2">Search</div>
                                <div class="col-sm-10">
                                    <input type="month" id="month" class="form-control w-28 float-right">
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
                                            colspan="1" aria-label="Browser: activate to sort column ascending">Service Type
                                        </th>
                                        <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1"
                                            colspan="1" aria-label="Platform(s): activate to sort column ascending">
                                            Total Book</th>
                                        <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1"
                                            colspan="1" aria-label="Engine version: activate to sort column ascending">
                                            TotalPay</th>
                                        <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1"
                                            colspan="1" aria-label="CSS grade: activate to sort column ascending">
                                            Total Fee</th>
                                        <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1"
                                            colspan="1" aria-label="CSS grade: activate to sort column ascending">
                                            Month</th>
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
                                            <button class="btn"><i class="fas fa-bell"></i></button>
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
    $("#month").change(function () {
		var xDate = $("#month").val();
		$.ajax({
			url: "http://localhost:8090/admin/registerform",
			data: {
				date: xDate,
			}

		});

	});
</script>