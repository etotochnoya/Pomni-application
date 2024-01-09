const field = document.getElementById("cardField")

const NUMBER_OF_CARD = 12
const DEFAULT_COLOR = 'aliceblue'

const cards = []
for(let i = 0; i < NUMBER_OF_CARD; i++){
    let myColor = getRandomColor()
    cards.push({
        //bgColor: myColor,
        color: DEFAULT_COLOR,
        isClicked: false,
        isGuessed: false
    })
}

function generatePairs(){
    var numbers = Array.from(Array(NUMBER_OF_CARD).keys())

    for(let i = 0; i < numbers.length; i++){
        let j = Math.floor(Math.random() * numbers.length)
        let temp = numbers[i]
        numbers[i] = numbers[j]
        numbers[j] = temp
    }

    for(let i = 0; i < numbers.length; i += 2){
        let color = getRandomColor()
        cards[numbers[i]].color = color
        cards[numbers[i + 1]].color = color
    }
}

generatePairs()
cardRender()

function cardRender(){
    field.innerHTML = ''
    for(let i = 0; i < NUMBER_OF_CARD; i++){
        field.insertAdjacentHTML('beforeend', `
            <li>
                <div class="miniCard" style="background-color: ${cards[i].isClicked || cards[i].isGuessed ? cards[i].color : DEFAULT_COLOR};" data-index="${i}">${i}</div>
            </li>
        `)
    }
}



let guessedCardCounter = 0
let typpedCard = undefined

field.onclick = function(event){
    let i = event.target.dataset.index
    if(cards[i].isGuessed)
        return

    if(i != undefined){
        if(typpedCard === undefined){
            let i = event.target.dataset.index
            
            cards[i].isClicked = !cards[i].isClicked
            
            cardRender()
            typpedCard = i  
        }else{
            let i = event.target.dataset.index
            cards[i].isClicked = !cards[i].isClicked
            cardRender()
            if(cards[i].color === cards[typpedCard].color && i != typpedCard){
                cards[i].isGuessed = true
                cards[typpedCard].isGuessed = true
                guessedCardCounter += 2
            }else{
                setTimeout(40000)
                cards[i].isClicked = false
                cards[typpedCard].isClicked = false
                cardRender()
            }
            typpedCard = undefined
        }
    }

    if(guessedCardCounter === NUMBER_OF_CARD){
        alert('')
    }
}

function getRandomColor(){
    let color = "#"
    let symbols = '0123456789ABCDEF'
    for(let i = 0; i < 6; i++)
        color += symbols[Math.floor(Math.random() * 16)]
    return color
}