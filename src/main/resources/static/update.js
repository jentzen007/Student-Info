
document.addEventListener('DOMContentLoaded', () => {
    const student = JSON.parse(localStorage.getItem('student'));
    console.log(student);
    const id = student.id;
    const name = student.name;
    const grade = student.grade;
    const dob = student.birth_date;
    const marks = student.marks;
    const username = student.username;
    const password = student.password;

    document.getElementById('studentId').value = id;
    document.getElementById('name').value = name;
    document.getElementById('grade').value = grade;
    document.getElementById('bdate').value = dob;
    document.getElementById('marks').value = marks;
    document.getElementById('username').value = username;
    document.getElementById('password').value = password;
});

async function update() {
    const id = document.getElementById('studentId').value;
    const name = document.getElementById('name').value;
    const dob = document.getElementById('bdate').value;
    const marks = document.getElementById('marks').value;
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;

    const updatedStudent = {
        name: name,
        birth_date: dob,
        marks: parseInt(marks),
        password: password,
        username: username
    };

    const response = await fetch(`http://localhost:8080/students/update/${id}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(updatedStudent)
    });

    if(response.ok) {
        const serverDat = await response.json();
        localStorage.setItem("student", JSON.stringify(serverDat));
        alert('Updated Successfully!')
        await sleep(1000);
        window.location.href = 'main.html';
    } else {
        alert('Failed to update...');
        await sleep(1000);
        location.reload();
    }
}

function sleep(ms) {
    return new Promise(resolve => setTimeout(resolve, ms));
}