const canSum = (target, nums, dp) =>{
    if(target === 0)
        return true

    if(target < 0)
        return false

    if(target in dp)
        return dp[target]

    for(let num of nums){
        if(canSum(target - num, nums, dp))
            {
                dp[target] = true
                return true
            }
    }
    dp[target] = false
    return false
}

console.log(canSum(300,[7,14], {}))

