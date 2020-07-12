function square(num) {
    return num * num;
}
console.log(square(5));
// Output: 25
// Function expression
const squareFE = function (num) {
    return num * num;
};
// Higher-order function
function add(a) {
    return function (b) {
        return a + b;
    };
}
const addWith5 = add(5);
console.log(add(5)(5));
console.log(addWith5(15));
//# sourceMappingURL=Ham.js.map