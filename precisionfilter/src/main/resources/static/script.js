function storeValue() {
    const inputElement = document.getElementById('text-box');
    const inputValue = inputElement.value;
    analyzeEmail(inputValue);
}

function analyzeEmail(emailText) {
  fetch("/analyzeEmail", {
    method: "POST", 
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ text: emailText })
  })
  .then(res => res.json())
  .then(data => {
    // Display AI response in the aiOutput div
    document.getElementById("aiOutput").innerText = data.content;
  })
  .catch(err => {
    console.error("Error analyzing email:", err);
    document.getElementById("aiOutput").innerText = "Error analyzing email.";
  });
}
