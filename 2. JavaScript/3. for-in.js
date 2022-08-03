/*
    Java에서는 for each문을 통해 객체를 쉽게 참조할 수 있다.
    자바스크립트는 for in문을 통해 객체를 쉽게 참조할 수 있다.

    for (속성명 in 반복할 대상)
*/

var store = {
    snack : 1000,
    flower : 5000,
    beverage : 2000
};

for (var item in store) {
    // hasOwnProperty를 이용하여 store 객체에 item 키 정보가 있는지 확인한다.
    if (!store.hasOwnProperty(item)) continue;
    
    console.log(item + '는 가격이 ' + store[item] + '이다.');
}

