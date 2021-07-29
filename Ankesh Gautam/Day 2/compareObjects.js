var object1 = {
    age: 22,
    name: "Ankesh"
};

var object2 = {
    name: "Ankesh",
    age: 22
};

console.log("Is object1 = object2 ? " + (compareObjects(object1, object2) && compareObjects(object2, object1)));

function compareObjects(object1, object2) {
    for (var key in object1) {
        if (object1[key] !== object2[key])
            return false;
    }
    return true;
}
