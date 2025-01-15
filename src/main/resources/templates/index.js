// Hàm load danh sách khuyến mãi
function loadPromotion() {
    $.ajax({
        method: "GET",
        url: "http://localhost:8080/api/promotions",
        success: function (data) {
            let promotionsHtml = "";
            data.forEach((promotion) => {
                promotionsHtml += `
                        <tr>
                            <td>${promotion.title}</td>
                            <td>${promotion.startDate}</td>
                            <td>${promotion.endDate}</td>
                            <td>${promotion.discount}</td>
                            <td>${promotion.details}</td>
                            <td class="action-buttons">
                                <button onclick="editPromotion(${promotion.id})">&#9998;</button>
                            </td>
                            <td class="action-buttons">
                                <button onclick="deletePromotion(${promotion.id})">&#128465;</button>
                            </td>
                        </tr>`;
            });
            $("#promotion").html(promotionsHtml);
        },
        error: function () {
            alert("Không thể tải danh sách khuyến mãi.");
        }
    });
}

// Hàm xóa khuyến mãi
function deletePromotion(id) {
    if (confirm("Bạn có chắc muốn xóa không?")) {
        $.ajax({
            method: "DELETE",
            url: `http://localhost:8080/api/promotions/${id}`,
            success: function () {
                alert("Xóa thành công!");
                loadPromotion(); // Reload danh sách khuyến mãi
            },
            error: function () {
                alert("Không thể xóa khuyến mãi này.");
            }
        });
    }
}

// Hàm chỉnh sửa khuyến mãi
function editPromotion(id) {
    // Điều hướng đến trang sửa khuyến mãi
    window.location.href = `/edit-promotion/${id}`;
}

// Tải danh sách khuyến mãi khi trang được load
loadPromotion();
