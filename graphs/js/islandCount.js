const grid = [
    ['w','l','w','w','w'],
    ['w','l','w','w','w'],
    ['w','w','w','l','w'],
    ['w','w','l','l','w'],
    ['l','w','w','l','l'],
    ['l','l','w','w','w']
]


const islandCount = () => {
    const visited = new Set()
    let count = 0

    for(let i = 0; i< grid.length; i++){
        for(let j=0;j<grid[i].length;j++){
            if(grid[i][j] === 'l'){
                if(explore(i,j,visited))
                    count +=1
            }
        }

    }
    return count
}

const explore = (i,j, visited) =>{

    const rb = 0 <= i && i < grid.length
    const cb = 0 <= j && j < grid[0].length

    if(!rb || !cb || grid[i][j] === 'w') return false

    const pos = i + "," + j
    if((visited.has(pos))){
        return false
    }

    visited.add(pos)

    explore(i-1,j,visited)
    explore(i+1,j,visited)

    explore(i,j+1,visited)
    explore(i,j-1,visited)
    
    return true

}

console.log(islandCount())