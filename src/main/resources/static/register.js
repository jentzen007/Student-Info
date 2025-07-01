async function createStudent() {

    const student = {
    name: document.getElementById('name').value,
    username: document.getElementById('username').value,
    password: document.getElementById('password').value,
    birth_date: document.getElementById('birthDate').value,
    marks: parseInt(document.getElementById('marks').value)
    };
    const response = await fetch(`http://localhost:8080/students`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(student)
    });

    if(response.ok) {
        alert("Student Creation Successful!");
    } else {
        alert("Student Creation Failed!")
    }
}