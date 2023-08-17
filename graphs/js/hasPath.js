const graph = {
    f: ['g','i'],
    g: ['h'],
    h:[],
    i:['g','k'],
    j:['i'],
    k:[]
}

const hasPath_DFS = (graph, source, dest) =>{
    
    const stack = [source]

    while(stack.length > 0)
    {
        const current = stack.pop()
         
        if(current == dest)
            return true

        for (let neighbor of graph[current]){
            stack.push(neighbor)
        }
    }
    return false

}

const hasPath_DFS_Recursive = (graph,source,dest) => {
    if (source === dest)
        return true

    for( let neighbor of graph[source]){
        if(hasPath_DFS_Recursive(graph, neighbor, dest))
            return true
    }
    return false
}

const hasPath_BFS = (graph, source, dest) =>{
    
    const queue = [source]

    while(queue.length > 0){
        const current = queue.shift()
        if (current === dest)
            return true
        for (let neighbor of graph[current]){
            queue.push(neighbor)
        }
    }
    return false

}

console.log(hasPath_DFS(graph,'f','k'))
console.log(hasPath_DFS_Recursive(graph,'f','k'))
console.log(hasPath_BFS(graph,'f','k'))
