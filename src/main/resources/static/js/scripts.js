var host = window.location.origin;

function postData() {
    console.log("posting data...");

    var input_modelNo = $("#").val();
    var input_fuel;
    var input_brand;
    var input_type;

    // Create JS object with data.
    var newAirplane = {
        modelNo: input_modelNo,
        fuelLevel: input_fuel,
        brand: input_brand,
        type: input_type
    };
    console.log(newAirplane);

    // Convert JS object to JSON.
    var validJsonAirplane = JSON.stringify(newAirplane);
    console.log(newAirplane);

    // Post JSON to endpoint.
    $.ajax({
        url: host + "/api/v1/airplanes/add",
        type:"post",
        data: validJsonAirplane,
        contentType: "application/json",
        success: function(result) {
            // On successful post, reload data to get the added one as well.
            console.log("API Success function");
            console.log(result);
            getData();
        }
    });
}

// function setFormValidation(id) {
//     $(id).validate({
//         highlight: function(element) {
//         $(element).closest('.form-group').removeClass('has-success').addClass('has-danger');
//         $(element).closest('.form-check').removeClass('has-success').addClass('has-danger');
//         },
//         success: function(element) {
//         $(element).closest('.form-group').removeClass('has-danger').addClass('has-success');
//         $(element).closest('.form-check').removeClass('has-danger').addClass('has-success');
//         },
//         errorPlacement: function(error, element) {
//         $(element).closest('.form-group').append(error);
//         },
//     });
// }

function getData() {
    console.log("getting data...");

    // Get the data from endpoint.
    $.ajax({
        url: host + "/api/v1/airplanes/get",
        type:"get",
        success: function(airplanes) {
            // On successful get, reload the datatable with new data.
            console.log("This is the data: ");
            airplanes.forEach(element => {
                console.log(element);
            });
            $('#datatables').DataTable().clear();
            $('#datatables').DataTable().rows.add(airplanes);
            $('#datatables').DataTable().columns.adjust().draw();
        }
    });
}