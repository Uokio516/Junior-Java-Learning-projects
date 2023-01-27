import openai;


openai.api_key = "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"

response = openai.Completion.create(
    model="text-davinci-003",
    prompt="\nHuman: 請詳細解釋BFS和DFS是什麼? \nAI:",
    temperature=0.9,
    max_tokens=1000,
    top_p=1,
    frequency_penalty=0.0,
    presence_penalty=0.6,
    stop=[" Human:", " AI:"]
)


print(response["choices"][0]["text"])
