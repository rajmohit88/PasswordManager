// src/main/resources/static/script.js

function savePassword() {
    const username = document.getElementById('username').value;
    const service = document.getElementById('service').value;
    const password = document.getElementById('password').value;

    fetch(`/api/passwords/save?username=${username}&service=${service}&password=${password}`, {
        method: 'POST'
    })
    .then(res => res.text())
    .then(msg => {
        document.getElementById('result').innerText = msg;
    });
}

function getPassword() {
    const username = document.getElementById('getUsername').value;
    const service = document.getElementById('getService').value;

    fetch(`/api/passwords/get?username=${username}&service=${service}`)
        .then(res => res.text())
        .then(pwd => {
            document.getElementById('fetchedPassword').innerText = "Password: " + pwd;
        });
}

function getAll() {
    fetch(`/api/passwords/all`)
        .then(res => res.json())
        .then(data => {
            const table = document.getElementById('credentialsTable');
            const tbody = table.querySelector('tbody');
            tbody.innerHTML = "";
            data.forEach(entry => {
                const row = `<tr><td>${entry.username}</td><td>${entry.service}</td><td>${entry.encryptedPassword}</td></tr>`;
                tbody.innerHTML += row;
            });
            table.style.display = 'table';
        });
}
script