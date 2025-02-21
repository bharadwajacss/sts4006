class TowerofHanoi{
    public static void main(String[] args){
        int n = 5;
        towerofhanoi(n,'a','b','c');


    }
    static void towerofhanoi(int n, char a ,char b,char c){
        if(n==1){
            System.out.println("Move "+n + "from " + a +" to" + c );
        }
        else{
            towerofhanoi(n-1,a,c,b);
             System.out.println("Move "+n + "from " + a +" to" + b );
             towerofhanoi(n-1,b,c,a);
        }

    }
}