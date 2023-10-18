const edges = [
    ['w','x'],
    ['x','y'],
    ['z','y'],
    ['z','v'],
    ['w','v'],

]

const buildGraph = (edges) => {

    const graph = {}

    for (let edge of edges){

        const [a,b] = edge

        if(!(a in graph)) graph[a] = []
        if(!(b in graph)) graph[b] = []

        graph[a].push(b)
        graph[b].push(a)


    }
    return graph
}


const shortestPath = (edges, src, dest) => {

    const graph = buildGraph(edges)
    const queue = [[src, 0]]
    
    const visited = new Set()
    visited.add(src)

    while (queue.length > 0)
    {
        const [curr, dist] = queue.shift()

        if(curr === dest) return dist

        for(let neighbor of graph[curr]){
            if(!(visited.has(neighbor)))
            visited.add(neighbor)
            queue.push([neighbor, dist + 1])
        }
    }

    return -1
    //const result = countPath(graph, src, dest, visited)


    console.log(result)
}

console.log(shortestPath(edges, 'w', 'z'))
