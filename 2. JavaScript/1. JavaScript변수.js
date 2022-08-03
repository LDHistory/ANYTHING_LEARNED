/* 변수 */

/* JavaScript는 별도의 키워드 없이 변수 선언이 가능하다.
   이러한 선언 방식을 '암시적 선언' 이라한다.
    
   그러나 암시적 선언보다 키워드를 사용하여 변수를 선언하는 것을 권장한다.
*/
foo = "bar";
console.log(foo);

/* 선언 키워드 
    JavaScript는 다른 컴파일 언어와 달리 값을 변수로 저장할 때 어떤 유형인지 명시하지 않아도 된다.
    그리고 일관된 var키워드를 맨 앞에 작성하여 변수를 선언한다.
    프로그래밍할 때 값의 유형을 일일이 명시하지 않으면, 런타임 시 변수의 값에 의해 동적으로 유형이 결정되는데,
    이를 Dynamic Binding(동적 바인딩)이라 한다.
*/
var name = "DHL";
var number = 10;
var isBoolean = true;
var nothing = null;
var empty = undefined;
var list = [];
var ref = {};
var func = function(){};