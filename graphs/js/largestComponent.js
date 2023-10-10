const graph = {
    0: [8,1,5],
    1: [0],
    5: [0,8],
    8: [0,5],
    2: [3,4],
    3: [2,4],
    4: [3,2]
}

const largestComponent= (graph) =>{

    const visited = new Set()
    const dic = {}

    for(let node in graph){
        
        let traverseResult = traverse(graph, String(node), visited)
        if(!dic[node] && traverseResult> 0)
            dic[node] = traverseResult
    }

    return dic
}

const traverse = (graph, node, visited) => {

    if(visited.has(String(node)))
        return 0

    visited.add(String(node))
    let size = 1

    for(let neighbor of graph[node]){
        size += traverse(graph, neighbor, visited)
    }

    return size
}

const getMaxSize = (componentDictionary) => {
    let Mkey, Mval, max= 0

    for (const [key, value] of Object.entries(componentDictionary)){
        if( value > max){
            Mkey = key
            Mval = value
            max = value
        }
    }
    return [Mkey, Mval]
}

componentDictionary = largestComponent(graph)   // returns size of each component with key as one of the node in that component

const [Mkey, Mval] = getMaxSize(componentDictionary)

console.log("Component containing node "+Mkey+ " has largest size of "+Mval)





