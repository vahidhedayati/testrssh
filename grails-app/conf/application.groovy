remotessh {
    HOST = "localhost"
    USER = "mx1"
    //PASS=""
    KEY="/home/mx1/.ssh/id_rsa"
    KEYPASS=""
    PORT="22"

    /*
     * keepAliveTime in seconds
     */
    keepAliveTime=300

    /*
     * corePoolSize this should match maximumPoolSize
     *
     */
    corePoolSize=3
    /*
     * maxPoolSize
     *
     */
    maximumPoolSize=3

    /*
     * Amount of elements that can queue
     */
    maxQueue=100

}
//0.11 new customised config values can be defined

mySshConfigVar.HOST = "localhost"
mySshConfigVar.USER = "mx1"
mySshConfigVar.PASS="password"
//mySshConfigVar.KEY="/home/mx1/.ssh/id_rsa"
//mySshConfigVar.KEYPASS=""
mySshConfigVar.PORT="22"


mySshConfigVar2.HOST = "localhost"
mySshConfigVar2.USER = "mx1"
mySshConfigVar2.PASS="password"
//mySshConfigVar.KEY="/home/mx1/.ssh/id_rsa"
//mySshConfigVar.KEYPASS=""
mySshConfigVar2.PORT="22"
