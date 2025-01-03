async function searchCharacter() {
    const name = document.getElementById("characterName").value;
    const resultsDiv = document.getElementById("results");

    resultsDiv.innerHTML = "Loading...";

    try {
        const response = await fetch(`http://localhost:8080/encyclopedia/characters/${name}`);
        const data = await response.json();

        const character = data.data.results[0]; // Primer resultado
        if (character) {
            resultsDiv.innerHTML = `
                <div class="character">
                    <img src="${character.thumbnail.path}.${character.thumbnail.extension}" alt="${character.name}">
                    <div class="character-details">
                        <h2>${character.name}</h2>
                        <p>${character.description || "No description available."}</p>
                    </div>
                </div>
            `;
        } else {
            resultsDiv.innerHTML = "<p>Character not found.</p>";
        }
    } catch (error) {
        resultsDiv.innerHTML = `<p style="color: red;">Error: ${error.message}</p>`;
    }
}