const grid = [
    ['w','l','w','w','w'],
    ['w','l','w','w','w'],
    ['w','w','w','l','w'],
    ['w','w','l','l','w'],
    ['l','w','w','l','l'],
    ['l','l','w','w','w']
]

const minIsland = () =>{
    const visited = new Set()

    let minSize = Infinity;
    const islandSize = {}

    for(let i=0;i<grid.length;i++){
        for(let j=0;j<grid[i].length;j++){
            if(grid[i][j]==='l'){
                const size = explore(i,j,visited)
                if(size > 0){
                minSize = size < minSize ? size: minSize
                if(!islandSize[i+','+j]){
                    islandSize[i+','+j] = size
                }

                }
            }
        }
    }
    return [minSize,islandSize]
}

const explore = (i,j,visited) => {

    const rb = 0 <= i && i < grid.length
    const cb = 0 <= j && j < grid[0].length

    if(!rb || !cb || grid[i][j] === 'w') return 0
    const pos = i + ',' + j

    if(visited.has(pos)) return 0;

    visited.add(pos)

    let size = 1

    size += explore(i+1,j,visited)
    size += explore(i-1,j,visited)
    size += explore(i,j+1,visited)
    size += explore(i,j-1,visited)

    return size


}

const [minSize,islandSize] = minIsland()
console.log("minSize: ", minSize)
console.log("IslandsSize: ", islandSize)
const getMinSize = (islandSize) => {
    let Mkey, Mval, min= Infinity

    for (const [key, value] of Object.entries(islandSize)){
        if( value < min){
            Mkey = key
            Mval = value
            min = value
        }
    }
    return [Mkey, Mval]
}
const [Mkey, Mval] = getMinSize(islandSize)

console.log("Component containing node "+Mkey+ " has smallest island size of "+Mval)
