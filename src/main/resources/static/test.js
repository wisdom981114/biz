

// 장바구니에 해당 상품을 추가하는 코드
function addToCart() {
    alert('장바구니에 추가되었습니다.');

}

// 오름차순 정렬
function sortAscending() {
    const products = document.querySelector('.product-list');
    const items = Array.from(products.children);

    items.sort((a, b) => {
        const priceA = parseInt(a.querySelector('.product-price').textContent.replace(',', ''));
        const priceB = parseInt(b.querySelector('.product-price').textContent.replace(',', ''));
        return priceA - priceB;
    });

    products.innerHTML = '';
    items.forEach(item => products.appendChild(item));
}
// 내림차순 정렬
function sortDescending() {
    const products = document.querySelector('.product-list');
    const items = Array.from(products.children);

    items.sort((a, b) => {
        const priceA = parseInt(a.querySelector('.product-price').textContent.replace(',', ''));
        const priceB = parseInt(b.querySelector('.product-price').textContent.replace(',', ''));
        return priceB - priceA;
    });

    products.innerHTML = '';
    items.forEach(item => products.appendChild(item));
}

// 이름순 정렬
let ascending = true; // 정렬 방향

function sortByName() {
    let productList = document.querySelector('.product-list');
    let productItems = Array.from(productList.children);

    productItems.sort(function (a, b) {
        let nameA = a.querySelector('.product-name').textContent.trim().toLowerCase();
        let nameB = b.querySelector('.product-name').textContent.trim().toLowerCase();

        if (nameA < nameB) {
            return ascending ? -1 : 1;
        }
        if (nameA > nameB) {
            return ascending ? 1 : -1;
        }
        return 0;
    });

    ascending = !ascending; // 정렬 방향 변경

    productList.innerHTML = '';
    productItems.forEach(function (item) {
        productList.appendChild(item);
    });
}


const categories = document.querySelectorAll(".category");
const brands = document.querySelectorAll(".brand");
const price = document.querySelector("#price");

function filter() {
  const categoryValue = document.querySelector('input[name="category"]:checked').value;
  const brandValue = document.querySelector('input[name="brand"]:checked').value;
  const priceValue = price.value;

}