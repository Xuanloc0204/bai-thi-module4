function addPromotion() {
    // Lấy dữ liệu từ form
    const formData = {
        title: $("#title").val(),
        startDate: $("#startDate").val(),
        endDate: $("#endDate").val(),
        discount: $("#discount").val(),
        details: $("#details").val()
    };

    // Gửi yêu cầu POST tới API
    $.ajax({
        method: "POST",
        url: "http://localhost:8080/api/promotions",
        data: formData,
        success: function () {
            alert("Thêm mới thành công!");
            window.location.href = "index.html"; // Quay lại trang danh sách
        },
        error: function () {
            alert("Không thể thêm khuyến mãi.");
        }
    });
}

