async function login() {
    const cred = {
        username: document.getElementById('username').value,
        password: document.getElementById('password').value
    };
    const response = await fetch('http://localhost:8080/students/login',{
        method: 'POST',
        headers: {
            'Content-Type':'application/json'
        },
        body: JSON.stringify(cred)
    });

    if(response.ok) {
        const student = await response.json();
        localStorage.setItem("student", JSON.stringify(student));
        window.location.href = "main.html";
    } else {
        alert("Invalid Credentials");
    }
}