object bank extends App {

    var bank : List[Account] = List( new Account("Sumudu" , 1 , -15000) , new Account("Harshani" , 2 , 45000) )

    val find = ( n : Int , b : List[Account]) => b.filter( x => x.accountNumber.equals( n ))

    val overdraft = ( b : List[Account] ) => b.filter( x => x.balance < 0)

    val balance = ( b: List[Account] ) => b.map( x => (x,x.balance) ).reduce( (a , c) => ( c._1 , a._2 + c._2) )

    val interest = ( b : List[Account] ) => b.map( x => {
        x.balance match {
            case a if a >= 0 => x deposit x.balance * 0.05
            case _ => x withdraw Math.abs(x.balance) * 0.1

        }
        x
    })


    println("bank " + bank )
    println()
    println("find " + find( 2 , bank) )
    println()
    println("overdraft " + overdraft( bank ) )
    println()
    println("balance " + balance( bank )._2 )
    println()

    bank = interest( bank )

    println("bank " + bank )
    println()
    println("balance " + balance( bank )._2 )
    println()

}

class Account ( x:String , y: Int , z : Double){

    val Name : String = x
    val accountNumber : Int = y
    var balance : Double = z

    def withdraw( amount : Double ) = this.balance -= amount

    def deposit ( amount : Double ) = this.balance += amount

    def transfer( amount : Double , that : Account ): Unit = {
        this.balance =  this.balance - amount
        that.balance = that.balance + amount
    }


    @Override
    override def toString() : String = "\n Name : " + this.Name + "\n Account Number : " + this.accountNumber + "\n Balance : " + this.balance

}
