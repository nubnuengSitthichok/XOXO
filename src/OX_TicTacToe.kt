import java.util.Scanner

var arr = arrayOf(
        '1', '2', '3',
        '4', '5', '6',
        '7', '8', '9'
)
var flag = true;
fun main() {
    val kb = Scanner(System.`in`)
    var round = 0;

    while (flag) {
        if (round % 3 == 0) {
            print("This turn X set your position :  ")
            var input = kb.next();
            setTable(input, 'X')
        } else {
            print("This turn Y set your position :  ")
            var input = kb.next();
            setTable(input, 'Y')
        }
        checkDraw()
        round++;
    }
}

fun setTable(pos: String, player: Char) {
    for (i in arr) {
        if (pos.contains(i)) {
            arr[pos.toInt() - 1] = player
        }
    }
    printTable()
    checkHorizantal(player.toString())
    checkVertical(player.toString())
    chcekDiagonal(player.toString())
}

fun printTable() {
    var count = 1;
    for (i in arr) {
        if (count % 3 === 0) {
            println(" $i ")
        } else {
            print(" $i ")
        }
        count++;
    }
}

fun checkHorizantal(player: String) {
    for (i in 0..6) {
        if (i.toInt() % 3 === 0) {
            if (player.contains(arr[i]) && player.contains(arr[i + 1]) && player.contains(arr[i + 2])) {
                println("${player} Win!!!")
                flag = false
            }
        }
    }
}

fun checkVertical(player: String) {
    for (i in 0..2) {
        if (player.contains(arr[i]) && player.contains(arr[i + 3]) && player.contains(arr[i + 6])) {
            println("${player} Win!!!")
            flag = false
        }
    }
}

fun chcekDiagonal(player: String) {
    if (player.contains(arr[0]) && player.contains(arr[4]) && player.contains(arr[8])) {
        println("${player} Win!!!")
        flag = false
    }
    if (player.contains(arr[2]) && player.contains(arr[4]) && player.contains(arr[6])) {
        println("${player} Win!!!")
        flag = false
    }
}

fun checkDraw(){
    var count = 0
    for (i in arr) {
        if(i === 'X' || i=== 'Y'){
            count++;
        }
    }
    if(count == 9){
        println("DRAW!!!!")
        flag = false
    }
}
