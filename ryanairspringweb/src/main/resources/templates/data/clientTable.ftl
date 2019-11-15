<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Aircraft Table</title>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.css"/>
    <script type="text/javascript" src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.js"></script>

<!--    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>-->

    <script type="text/javascript">
        $(document).ready(function () {
            $.ajax({
                url: "http://localhost:8080/client",
                method: "GET",
                dataType: "json",
                success: function (data) {
                    $("#datatable").dataTable({
                        data: data,
                        columns: [
                            {'data': 'id'},
                            {'data': 'firstName'},
                            {'data': 'middleName'},
                            {'data': 'lastName'},
                            {'data': 'phone'},
                            {'data': 'email'},
                            {'data': 'passport'},
                            {'data': 'countryName'},
                        ]
                    })
                }
            })
                .fail(function (e) {
                    alert(e.statusText);
                    console.log('er', e)
                })
        })
    </script>
</head>

<body>
    <div style="width: 850px; padding: 5px; border: 1px solid black; text-align: center">
        <table id="datatable">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>First Name</th>
                    <th>Middle Name</th>
                    <th>Last Name</th>
                    <th>Phone</th>
                    <th>Email</th>
                    <th>Passport</th>
                    <th>Country Name</th>
                </tr>
            </thead>
        </table>
    </div>
</body>
</html>