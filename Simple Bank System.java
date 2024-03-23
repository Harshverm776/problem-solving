// LC
// 2043. Simple Bank System

// Using Array - Initial approach
// T = O(1);
// S = O(n);
class Bank {

    private long[] accounts;

    public Bank(long[] balance) {
        this.accounts = balance;
    }
    
    public boolean transfer(int account1, int account2, long money) {
        if(isValidAccount(account1) && isValidAccount(account2) && hasSufficientBalance(account1, money)) {
          accounts[account1-1] -= money;
          accounts[account2-1] += money;
          return true;
        }
        return false;
    }
    
    public boolean deposit(int account, long money) {
      if(isValidAccount(account)) {
        accounts[account-1] += money;
        return true;
      }
      return false;
    }
    
    public boolean withdraw(int account, long money) {
      if(isValidAccount(account)) {
          if(hasSufficientBalance(account, money)) {
            accounts[account-1] -= money;
            return true;
          }
      }
      return false;
    }

    private boolean isValidAccount(int account) {
      // 1<= account - constraint 
      return account<=accounts.length ? true : false; 
    }

    private boolean hasSufficientBalance(int account, long money) {
      return accounts[account-1]>=money ? true : false; 
    }
}


// Better to use HashMap - more optimized
// T = O(1);
// S = O(n);
class Bank {
    private HashMap<Integer, Long> map;
    public Bank(long[] balance) {
        this.map = new HashMap<>();
        for(int i = 0; i < balance.length; i++){
            map.put(i+1, balance[i]);
        }
    }
    
    public boolean transfer(int account1, int account2, long money) {
        if(map.containsKey(account1) && map.containsKey(account2)){
            if(map.get(account1) >= money){
                map.put(account1, map.get(account1) - money);
                map.put(account2, map.get(account2) + money);
                return true;
            }
        }
        return false;
    }
    
    public boolean deposit(int account, long money) {
        if(map.containsKey(account)){
            map.put(account, map.get(account) + money);
            return true;
        }
        return false;
    }
    
    public boolean withdraw(int account, long money) {
        if(map.containsKey(account) && map.get(account) >= money){
            map.put(account, map.get(account) - money);
            return true;
        }
        return false;
    }
}
