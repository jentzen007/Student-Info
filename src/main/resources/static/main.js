document.addEventListener('DOMContentLoaded', () => {
  const toggleBtn = document.getElementById('menu-toggle');
  const navbar = document.getElementById('navbar');

  toggleBtn.addEventListener('click', () => {
    navbar.classList.toggle('expanded');
  });

  // Populate student data
  const student = JSON.parse(localStorage.getItem('student'));
  if (student) {
    document.getElementById('greeting').textContent = `Welcome, ${student.name}`;
    document.getElementById('id').innerHTML = `<strong>ID:</strong> ${student.id}`;
    document.getElementById('name').innerHTML = `<strong>Name:</strong> ${student.name}`;
    document.getElementById('age').innerHTML = `<strong>Age:</strong> ${student.age}`;
    document.getElementById('dob').innerHTML = `<strong>Date of Birth:</strong> ${student.birth_date}`;
    document.getElementById('marks').innerHTML = `<strong>Marks:</strong> ${student.marks}`;
    document.getElementById('grade').innerHTML = `<strong>Grade:</strong> ${student.grade}`;
  }
});

function logout() {
  localStorage.clear();
  window.location.href = "login.html";
}

async function deleteAcc() {
  const student = JSON.parse(localStorage.getItem('student'));
  const id = student.id;
  const psw = prompt('Enter Password');
  if(psw == student.password) {
    const response = await fetch(`http://localhost:8080/students/delete/${id}`, {
      method: 'DELETE',
      headers: {
        'Content-Type': 'application/json',
      }
    });
    if(response.ok) {
      alert('Account Successfully Deleted!');
      localStorage.clear();
      await sleep(1000);
      window.location.href = 'login.html';
    } else {
      alert('Account can not be deleted.');
    }
  } else {
    alert('Incorrect Password');
  }
}

function sleep(ms) {
  return new Promise(resolve => setTimeout(resolve, ms));
}