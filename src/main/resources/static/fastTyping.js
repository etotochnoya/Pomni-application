const alreadyInputDiv = document.getElementById("already-input-div")
const inputDiv = document.getElementById("input-div")
const restartBtn = document.getElementById("restart-button")

const MAX_SHOW_TEXT_SIZE = 11

let index = 0
getText = async () => {
  const url = 'http://localhost:8080/fastTyping/data';// here s your loccalhost 9000....))

  const textResponse = await makeRequest('GET', url);
  return JSON.parse(textResponse).text;
}

getText()
  .then(text => {
    inputDiv.textContent = text.substring(0, MAX_SHOW_TEXT_SIZE)

    document.onkeypress = function (event) {
        event = event || window.event;
        if(text[index] === event.key){
            index++
            alreadyInputDiv.textContent += event.key
            if(alreadyInputDiv.textContent.length > MAX_SHOW_TEXT_SIZE){
                alreadyInputDiv.textContent = alreadyInputDiv.textContent.substring(alreadyInputDiv.textContent.length - MAX_SHOW_TEXT_SIZE, alreadyInputDiv.textContent.length)
            }

            inputDiv.textContent = text.substring(index, MAX_SHOW_TEXT_SIZE + index)
        }
    }
  })
  .catch(err => console.log(err));

function makeRequest(method, url) {
    return new Promise(function (resolve, reject) {
        let xhr = new XMLHttpRequest();
        xhr.open(method, url);
        xhr.onload = function () {
            if (this.status >= 200 && this.status < 300) {
                resolve(xhr.response);
            } else {
                reject({
                    status: this.status,
                    statusText: xhr.statusText
                });
            }
        };
        xhr.onerror = function () {
            reject({
                status: this.status,
                statusText: xhr.statusText
            });
        };
        xhr.send();
    });
}