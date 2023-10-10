const traverse = (node) => {
    if(visited.has(node))
        return false

    visited.add(node)
    // console.log(visited)
    for( let nod of graph[node]){
        traverse(String(nod))        
    } 
    
    return true
}

const countComponents = (graph) =>{  

    for(let node in graph){
        if(traverse(String(node))){            
            count += 1

        }
    }

    return count
}
let count = 0
    const visited = new Set()
const graph = {
    3: [],
    4: [6],
    6: [4, 5, 7, 8],
    8: [6],
    7: [6],
    5: [6],
    1: [2],
    2: [1]
}

console.log(countComponents(graph))


