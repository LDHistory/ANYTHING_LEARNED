/*
    자바스크립트는 크게 두 가지 타입으로 구분한다.
    1. Primitive Data Type (원시 타입)
    2. Reference Data Type (참조 타입)
*/

/* 원시 타입

    원시 타입은 값이 변수에 할당될 때 메모리 상에 고정된 크기로 저장된다.
    즉, 해당 변수가 직접 값을 보관한다.

    Number, Boolean, String, Symbol, null, undefined
*/
var x = 5;
var y = 'five';
var isBoolean = true;
var empty = null;
var nothing = undefined;
var sym = Symbol('me');

/* 참조 타입

    참조 타입은 원시 타입과 달리 변수에 고정된 크기를 저장하지 않고, 값의 메모리 주소를 참조한다.
    즉, 값의 메모리 주소를 변수에 할당하여 값을 참조하게 된다.
*/

var item = {
    price : 5000,
    count : 10
};
var fruits = ['apple', 'orange', 'kiwi'];