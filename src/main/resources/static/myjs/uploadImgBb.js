function uploadFile() {

    var file = document.getElementById("fileOb");
    var form = new FormData();
    form.append("image", file.files[0]);
    var inputs = {
      //url: "F:\MyWorkspaceAMSG\HealthCareEx\images",  
      url: "https://api.imgbb.com/1/upload?key=459e60b64c983aaa3319a32aeacc9d8d",
      method: "POST",
      timeout: 0,
      processData: false,
      mimeType: "multipart/form-data",
      contentType: false,
      data: form,
    };
  
    $.ajax(inputs).done(function (response) {
      var job = JSON.parse(response);
      $("#imageUrl").val(job.data.url);
    });
  }