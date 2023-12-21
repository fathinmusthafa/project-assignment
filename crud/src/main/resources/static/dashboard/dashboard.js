$(document).ready(function () {
  
isiHome()

$("#home-button").click(function () {
    isiHome()
  });


$("#product-button").click(function () {
    isiContent();
    $("#isi-content").html("");
  });

  function isiContent() {
    $.ajax({
      url: "http://localhost:/products",
      type: "GET",
      dataType: "html",
      success: function (data) {
        isiProduct();
        $("#isi-content").html(data);
      },
    });
  }

  function isiHome(){
    $.ajax({
        url: "http://localhost:/home",
        type: "GET",
        dataType: "html",
        success: function (data) {
          isiProductByName();
          $("#isi-content").html(data);
        },
      });

  }

  function isiProduct() {
    $.ajax({
      url: "http://localhost:/api/products",
      type: "GET",
      success: function (data) {
        let txt = "";
        for (let i = 0; i < data.data.length; i++) {
          txt +=
            '<div class="col mb-5" ><div class="card h-100"><img class="card-img-top" src="https://placehold.it/450x300?text=IMAGE" alt="..." />';
          txt += '<div class="card-body p-4"><div class="text-center">';
          txt += "<h5> ID: " + data.data[i].id + "</h5>";
          txt += '<h4 class="fw-bolder">' + data.data[i].name + "</h4>";
          txt += "<h5> Rp." + data.data[i].price + "</h5>";
          txt += "<h6>Stock: " + data.data[i].qty + "</h6>";
          txt += "<h6>" + data.data[i].description + "</h6>";
          txt += "</div></div>";
          txt +=
            '<div class="card-footer p-4 pt-0 border-top-0 bg-transparent"><div class="text-center">';
          txt +=
            '<button type="button" class="editBtn btn btn-warning" name="' +
            data.data[i].id +
            '">';
          txt += '<i class="fa-solid fa-pen-to-square"></i>';
          txt +=
            '</button><button type="button" class="deleteBtn btn btn-danger ms-2" name="' +
            data.data[i].id +
            '">';
          txt += '<i class="fa-solid fa-trash"></i>';
          txt += "</button></div></div></div></div>";
        }
        $("#isi-product").html(txt);

        // edit button list
        $(".editBtn").click(function () {
          var id = $(this).attr("name");
          sessionStorage.setItem("ids", id);
          openEditPage();
        });

        // delete button list
        $('.deleteBtn').click(function(){
            var id = $(this).attr('name')
            sessionStorage.setItem('ids', id)
            openDeletePage()
        })
      },
    });
  }

  $("#search-button").click(function () {
    $.ajax({
      url: "http://localhost:/products",
      type: "GET",
      dataType: "html",
      success: function (data) {
        isiProductByName();
        $("#isi-content").html(data);
      },
    });
  });

  function isiProductByName() {
    let name = $("#form-search").val();
    $.ajax({
      url: "http://localhost:/api/product/?name=" + name,
      type: "GET",
      success: function (data) {
        let t = "";
        for (let i = 0; i < data.data.length; i++) {
          t +=
            '<div class="col mb-5" ><div class="card h-100"><img class="card-img-top" src="https://placehold.it/450x300?text=IMAGE" alt="..." />';
          t += '<div class="card-body p-4"><div class="text-center">';
          t += "<h5> ID: " + data.data[i].id + "</h5>";
          t += '<h4 class="fw-bolder">' + data.data[i].name + "</h4>";
          t += "<h5> Rp." + data.data[i].price + "</h5>";
          t += "<h6>Stock: " + data.data[i].qty + "</h6>";
          t += "<h6>" + data.data[i].description + "</h6>";
          t += "</div></div>";
          t +=
            '<div class="card-footer p-4 pt-0 border-top-0 bg-transparent"><div class="text-center">';
          t +=
            '<button type="button" class="editBtn btn btn-warning" name="' +
            data.data[i].id +
            '">';
          t += '<i class="fa-solid fa-pen-to-square"></i>';
          t +=
            '</button><button type="button" class="deleteBtn btn btn-danger ms-2" name="' +
            data.data[i].id +
            '">';
          t += '<i class="fa-solid fa-trash"></i>';
          t += "</button></div></div></div></div>";
        }

        $("#isi-product").html(t);

        $(".editBtn").click(function () {
            var id = $(this).attr("name");
            sessionStorage.setItem("ids", id);
            openEditPage();
          });

        $('.deleteBtn').click(function(){
            var id = $(this).attr('name')
            sessionStorage.setItem('ids', id)
            openDeletePage()
        })
      }
    });
  }

  $("#add-product").click(function () {
    $.ajax({
      url: "http://localhost:/addproduct",
      type: "GET",
      dataType: "html",
      success: function (data) {
        $("#modalAddProduct").modal("show");
        $(".isiModal").html(data);
        $(".modal-title").html("Add Product");
      },
    });
  });

  $("#productAddBtn").click(function () {
    let nama = $(".add-product").eq(0).val();
    let harga = $(".add-product").eq(1).val();
    let stock = $(".add-product").eq(2).val();
    let deskripsi = $(".add-product").eq(3).val();

    if (nama == "" || harga == null || stock == null || deskripsi == "") {
      alert("Input must not be blank");
    } else {
      let obj = {};
      obj.name = nama;
      obj.price = harga;
      obj.qty = stock;
      obj.description = deskripsi;
      let dataJson = JSON.stringify(obj);
      $.ajax({
        url: "http://localhost:/api/addproduct",
        type: "POST",
        contentType: "application/json",
        data: dataJson,
        success: function (data) {
          $("#modalAddProduct").modal("hide");
          isiContent();
        },
      });
    }
  });

  $("#productBatalAddBtn").click(function () {
    $("#modalAddProduct").modal("hide");
  });

  function getByIdEdit() {
    id = sessionStorage.getItem("ids");

    $.ajax({
      url: "http://localhost:80/api/productbyid/" + id,
      type: "GET",
      success: function (data) {
        $(".input").eq(0).val(data.data.id);
        $(".input").eq(1).val(data.data.name);
        $(".input").eq(2).val(data.data.price);
        $(".input").eq(3).val(data.data.qty);
        $(".input").eq(4).val(data.data.description);
      },
    });
  }

  function openEditPage() {
    $.ajax({
      url: "http://localhost:/dashboard",
      type: "GET",
      dataType: "html",
      success: function (data) {
        $("#modalEditProduct").modal("show");
        getByIdEdit();
        // $('#isiContent').html(data)
      },
    });
  }

  $("#productEditBtn").click(function () {
    let id = $(".input").eq(0).val();
    let name = $(".input").eq(1).val();
    let price = $(".input").eq(2).val();
    let qty = $(".input").eq(3).val();
    let description = $(".input").eq(4).val();

    if (name == "" || price == null || qty == null || description == "") {
      alert("Input must not be blank");
    } else {
      let obj = {};

      obj.name = name;
      obj.price = price;
      obj.qty = qty;
      obj.description = description;

      let dJson = JSON.stringify(obj);
      $.ajax({
        url: "http://localhost:80/api/update/" + id,
        type: "PUT",
        contentType: "application/json",
        data: dJson,
        success: function(data){
            $("#modalEditProduct").modal("hide");
            isiContent();
        },
      });
    }
  });

  $("#productBatalEditBtn").click(function () {
    $("#modalEditProduct").modal("hide");
  });


  function getByIdDelete() {
    id = sessionStorage.getItem("ids");

    $.ajax({
      url: "http://localhost:80/api/productbyid/" + id,
      type: "GET",
      success: function (data) {
        $(".input-del").eq(0).val(data.data.id);
        $(".input-del").eq(1).val(data.data.name);
        $(".input-del").eq(2).val(data.data.price);
        $(".input-del").eq(3).val(data.data.qty);
        $(".input-del").eq(4).val(data.data.description);
      },
    });
  }

  function openDeletePage() {
    $.ajax({
      url: "http://localhost:/dashboard",
      type: "GET",
      dataType: "html",
      success: function (data) {
        $("#modalDeleteProduct").modal("show");
        getByIdDelete();
        
      },
    });
  }

  $('#productDeleteBtn').click(function(){
    let id = $('.input-del').eq(0).val()
    var iduser = $('#IdUser').val()
    $.ajax({
        url:'http://localhost:80/api/delete/'+id ,
        type:'DELETE',
        contentType:'application/json',
        success:function(data){
            $("#modalDeleteProduct").modal("hide");
            isiContent()
        }
    })
    
  })

  $("#productBatalDeleteBtn").click(function () {
    $("#modalDeleteProduct").modal("hide");
  });



});
