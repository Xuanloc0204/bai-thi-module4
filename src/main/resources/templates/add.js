function addPromotion() {
    // Lấy dữ liệu từ form
    const formData = {
        title: $("#title").val(),
        startDate: $("#startDate").val(),
        endDate: $("#endDate").val(),
        discount: $("#discount").val(),
        details: $("#details").val()
    };

    console.log(JSON.stringify(formData));
    console.log("startDate:", formData.startDate);
    console.log("endDate:", formData.endDate);


    // Xác thực dữ liệu
    if (!formData.title || !formData.startDate || !formData.endDate || isNaN(formData.discount) || formData.discount <= 0 || !formData.details) {
        alert("Vui lòng nhập đầy đủ và đúng thông tin.");
        return;
    }

    if (new Date(formData.startDate) >= new Date(formData.endDate)) {
        alert("Ngày kết thúc phải sau ngày bắt đầu.");
        return;
    }

    // Gửi yêu cầu POST tới API
    $.ajax({
        method: "POST",
        url: "http://localhost:8080/api/promotions",
        contentType: "application/json",
        data:  JSON.stringify(formData),
        success: function () {
            alert("Thêm mới thành công!");
            window.location.href = "index.html"; // Quay lại trang danh sách
        },
        error: function () {
            alert("Không thể thêm khuyến mãi.");
        }
    });
}

