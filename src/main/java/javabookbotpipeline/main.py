def main():

    """using with methode and open function to open a filepath in quotes, save it as f, and using the .read methode to read the file and assign it to
    file_content """

    book_path = "./books/frankenstein.txt"
    text = get_book_text(book_path)
    ordered_dict = order_the_dict(count_of_characters(text))
    sorted_dict = sort_the_dict(ordered_dict)

   # print(f"{count_of_words(text)} words where found in the document at the path \"{book_path}\"")
    #print(f"{count_of_characters(text)} characters where found in the document at the path \"{book_path}\"")
    print(f"--- Begin report of {book_path} ---\n{count_of_words(text)} words where found in the document\n")
    for item in sorted_dict:
        print(f'The \"{item["character"]}\" character was found {item["count"]}')
    print(f"--- End of Report ---\n")



def order_the_dict(dict):
    list_of_dicts = []
    for character in dict:
        new_dict = {"character" : character, "count" : dict[character]}
        list_of_dicts.append(new_dict)
    return list_of_dicts

def sort_on(dict):
    return dict["count"]


def sort_the_dict(dict):
    dict.sort(reverse = True, key= sort_on)
    return dict





def count_of_characters(text):
    lowered_text = text.lower()
    character_dic = {}
    for character in lowered_text:
        if character.isalpha():
            if character not in character_dic:
                character_dic[character] = 1
            else:
                character_dic[character] += 1
    return character_dic



def get_book_text(path):

    
    with open(path) as f:
        return f.read()
        #print(file_content)


def count_of_words(text):
    words = text.split()
    return len(words)
        


main()