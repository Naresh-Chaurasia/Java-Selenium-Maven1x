const drag = document.getElementById("drag");
const drop = document.getElementById("drop");

drag.addEventListener("dragstart", function (e) {
  e.dataTransfer.setData("text/plain", "drag");
});

drop.addEventListener("dragover", function (e) {
  e.preventDefault();
});

drop.addEventListener("drop", function (e) {
  e.preventDefault();
  const data = e.dataTransfer.getData("text/plain");
  if (data === "drag") {
    drop.textContent = "Dropped!";
    drop.classList.add("dropped");
  }
});

function onDoubleClick() {
  document.getElementById("dblResult").innerText = "Double click successful!";
  document.getElementById("dblResult").style.color = "green";
}
